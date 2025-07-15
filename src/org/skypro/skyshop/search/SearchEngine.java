package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private List<Searchable> searchables = new ArrayList<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable item : searchables) {
            String searchTerm = item.getSearchTerm().toLowerCase();
            if (searchTerm.contains(query.toLowerCase())) {
                results.put(item.getName(), item);
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound("Поисковая строка не может быть пустой");
        }

        // Создаем переменную для хранения объекта с лучшим совпадением
        Searchable bestMatch = null;
        // Создаем переменную для хранения максимального числа вхождений
        int maxCount = 0;

        // Цикл по массиву объектов searchables, где count — количество элементов
        for (int i = 0; i < searchables.size(); i++) {

            // Получаем текущий объект из массива по индексу i
            Searchable item = searchables.get(i);

            // Если текущий объект null, пропускаем итерацию
            if (item == null) continue;

            // Получаем строку для поиска из объекта и приводим её к нижнему регистру
            String term = item.getSearchTerm().toLowerCase();

            // Приводим поисковую строку к нижнему регистру для поиска без учёта регистра
            String query = search.toLowerCase();

            // Подсчитываем количество вхождений query в term с помощью метода countOccurrences
            int count = countOccurrences(term, query);

            // Если текущее количество вхождений больше максимального, обновляем значения
            if (count > maxCount) {

                // Обновляем максимальное количество вхождений
                maxCount = count;

                // Сохраняем текущий объект как лучшее совпадение
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящего результата для запроса: " + search);
        }
        return bestMatch;
    }

    private int countOccurrences(String text, String substring) {
        // счётчик вхождений
        int count = 0;
        //  начальный индекс для поиска
        int index = 0;
        // Цикл: продолжаем, пока находим вхождения подстроки в строке
        while ((index = text.indexOf(substring, index)) != -1) {
            // Увеличиваем счётчик при каждом найденном вхождении
            count++;
            // Сдвигаем индекс на длину подстроки, чтобы искать следующее вхождение
            index += substring.length();
        }
        // Возвращаем общее количество найденных вхождений
        return count;
    }
}
