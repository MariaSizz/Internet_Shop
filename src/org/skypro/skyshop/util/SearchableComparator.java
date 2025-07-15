package org.skypro.skyshop.util;

import org.skypro.skyshop.search.Searchable;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int len1 = o1.getName().length();
        int len2 = o2.getName().length();

        if (len1 != len2) {
            return Integer.compare(len2, len1);
        }

        return o1.getName().compareTo(o2.getName());
    }
}