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

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound("Поисковая строка не может быть пустой");
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (int i = 0; i < count; i++) {

            Searchable item = searchables[i];

            if (item == null) continue;

            String term = item.getSearchTerm().toLowerCase();

            String query = search.toLowerCase();

            int count = countOccurrences(term, query);

            if (count > maxCount) {

                maxCount = count;

                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящего результата для запроса: " + search);
        }
        return bestMatch;
    }

    private int countOccurrences(String text, String substring) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}