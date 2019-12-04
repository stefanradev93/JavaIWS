package de.moviemanager.ui.masterlist.categorizer;


import java.util.Comparator;

import de.moviemanager.data.Nameable;
import de.moviemanager.ui.masterlist.elements.ContentElement;
import de.moviemanager.ui.masterlist.elements.DividerElement;
import de.moviemanager.ui.masterlist.elements.HeaderElement;
import de.util.StringUtils;

import java.util.function.Function;

import static java.util.Comparator.comparing;

public class Watched<T extends Nameable> extends Categorizer<String, T> {
    private final Comparator<ContentElement<T>> contentComparator =
        comparing(ContentElement::getTitle, StringUtils::alphabeticalComparison);

    private String watchedName;
    private Function<T, String> getWatchDate;

    public Watched(String watchedName, Function<T, String> getWatchDate){
        this.watchedName = watchedName;
        this.getWatchDate = getWatchDate;

    }


    @Override
    public String getCategoryNameFor(final T obj){
        String watchDate = getWatchDate.apply(obj);

        if (watchDate.isEmpty())
            return "unwatched";
        else
            return "watched";
    }

    @Override
    public HeaderElement<T> createHeader(String category){return new HeaderElement<>(category);}


    @Override
    protected ContentElement<T> createContent(T obj){
        String watchDate = getWatchDate.apply(obj);
        if (watchDate.isEmpty())
            return new ContentElement<>(obj.name(), "not watched yet");
        else
            return new ContentElement<>(obj.name(), watchedName+": "+watchDate);
    }

    @Override
    public DividerElement createDivider() {return new DividerElement();}


    @Override
    public int compareCategories(String cat1, String cat2) {
        int rank1 = ("watched".equals(cat1))? 0 : 1;
        int rank2 = 1-rank1;
        return Integer.compare(rank1, rank2);
    }


    @Override
    public int compareContent(final ContentElement<T> element1, final ContentElement<T> element2) {
        return contentComparator.compare(element1, element2);
    }

}
