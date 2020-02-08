package de.moviemanager.ui.masterlist.categorizer;


import java.sql.Date;
import java.util.Comparator;
import java.util.function.Function;

import de.moviemanager.data.Nameable;
import de.moviemanager.ui.masterlist.elements.ContentElement;
import de.moviemanager.ui.masterlist.elements.DividerElement;
import de.moviemanager.ui.masterlist.elements.HeaderElement;
import de.util.DateUtils;
import de.util.StringUtils;

import static java.util.Comparator.comparing;

public class Lent<T extends Nameable> extends Categorizer<String, T> {
    private final Comparator<ContentElement<T>> contentComparator =
        comparing(ContentElement::getTitle, StringUtils::alphabeticalComparison);

    private String lentName;
    private Function<T, String> getLendDate;

    public Lent(String lentName, Function<T, String> getLendDate){
        this.lentName = lentName;
        this.getLendDate = getLendDate;

    }


    @Override
    public String getCategoryNameFor(final T obj){
        String watchDate = getLendDate.apply(obj);

        if (watchDate.isEmpty())
            return "unlent";
        //if (DateUtils::differenceInDays(DateUtils::textToDate(watchDate), new Date()) < 0)
        //    return "overdue";
        else
            return "lent";
    }

    @Override
    public HeaderElement<T> createHeader(String category){return new HeaderElement<>(category);}


    @Override
    protected ContentElement<T> createContent(T obj){
        String lendDate = getLendDate.apply(obj);
        if (lendDate.isEmpty())
            return new ContentElement<>(obj.name(), "not lent");
        else
            return new ContentElement<>(obj.name(), lentName+": " + lendDate);
    }

    @Override
    public DividerElement createDivider() {return new DividerElement();}


    @Override
    public int compareCategories(String cat1, String cat2) {
        int rank1 = ("lent".equals(cat1))? 0 : 1;
        int rank2 = 1-rank1;
        return Integer.compare(rank1, rank2);
    }


    @Override
    public int compareContent(final ContentElement<T> element1, final ContentElement<T> element2) {
        return contentComparator.compare(element1, element2);
    }
}
