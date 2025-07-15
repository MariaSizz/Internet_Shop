package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables = new ArrayList<>();

    public void add(Searchable item) {
        searchables.add(item);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : searchables) {//создание переменной
            String searchTerm = item.getSearchTerm().toLowerCase();
            if (searchTerm.contains(query.toLowerCase())) {
                results.add(item);
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

        for (int i = 0; i < searchables.size(); i++) {

            Searchable item = searchables.get(i);

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
