package de.moviemanager.ui.masterlist.categorizer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


import de.moviemanager.data.Nameable;
import de.moviemanager.ui.masterlist.elements.ContentElement;
import de.moviemanager.ui.masterlist.elements.DividerElement;
import de.moviemanager.ui.masterlist.elements.HeaderElement;
import de.util.DateUtils;

import static de.util.DateUtils.now;
import static java.util.Comparator.comparing;

public class Due<T extends Nameable> extends Categorizer<String, T>  {


    private final Comparator<ContentElement<T>> contentComparator =
            comparing(ContentElement<T>::getMeta)
                    .thenComparing(ContentElement::getContent);


    private final Function <T, String> getDate;

    private int count =0;


    public Due(Function<T,String> getDate) {

        this.getDate = getDate;

    }

    private static final List<String> NAMES = Arrays.asList(
            "Overdue",
            "Due in a day/today",
            "Due in 3 days",
            "Due in a week",
            "Due in a month",
            "Due in future",
            "Not loaned");

    private int nameIndex(long daysRemaining){
        if (daysRemaining <0)
            return 0;
        else if (daysRemaining <1)
            return 1;
        else if (daysRemaining <= 3)
            return 2;
        else if (daysRemaining <= 7)
            return 3;
        else if (daysRemaining <= 31)
            return 4;
        else
            return 5;

    }

    private static long getDifferenceDays(Date d1, Date d2) {

        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    protected String getCategoryNameFor(T obj) {
        String date = getDate.apply(obj);
        Date d = DateUtils.textToDate("dd.MM.yyyy",date);




        if (!date.equals("")) {
            long daysRemaining = getDifferenceDays(now(),d);
            if (daysRemaining<0){

                count++;

                return NAMES.get(nameIndex(daysRemaining));

            }else {


                return NAMES.get(nameIndex(daysRemaining));
            }
        }else{
            return NAMES.get(6);
        }
    }



    @Override
    protected HeaderElement<T> createHeader(String category) {
        if (category.equals(NAMES.get(0))) {

            int number =count;
            count=0;


            return new HeaderElement<>(category + "  " + "Total Number: " + number);
        }else{
            return new HeaderElement<>(category);
        }
    }

    @Override
    protected ContentElement<T> createContent(T obj) {
        String date = getDate.apply(obj);
        Date d = DateUtils.textToDate("dd.MM.yyyy",date);
        if (!date.equals("")) {
            long daysRemaining = getDifferenceDays(new Date(),d);
            if(daysRemaining<0){
                date=NAMES.get(0);

                return new ContentElement<>(obj.name(), date);
            }else {
                return new ContentElement<>(obj.name(), date);
            }
        }else{
            date = NAMES.get(6);
            return new ContentElement<>(obj.name(), date);

        }



    }

    @Override
    protected DividerElement createDivider() {
        return new DividerElement();
    }

    @Override
    protected int compareCategories(String cat1, String cat2) {
        int result;

        int d1 = NAMES.indexOf(cat1);
        int d2 =NAMES.indexOf(cat2);
        result = d1-d2;



        return result;
    }

    @Override
    public int compareContent(final ContentElement<T> element1, final ContentElement<T> element2) {
        return contentComparator.compare(element1, element2);
    }

}

