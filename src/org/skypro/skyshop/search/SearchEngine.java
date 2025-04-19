package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    public void add(Searchable item) {
        if (count < searchables.length) {
            searchables[count] = item;
            count++;
        } else {
            System.out.println("Невозможно добавить объект: массив полон");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < count && resultCount < 5; i++) {
            String searchTerm = searchables[i].getSearchTerm().toLowerCase();
            if (searchTerm.contains(query.toLowerCase())) {
                results[resultCount] = searchables[i];
                resultCount++;
            }
        }

        return results;
    }
}
