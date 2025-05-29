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

        // Создаем переменную для хранения объекта с лучшим совпадением
        Searchable bestMatch = null;
        // Создаем переменную для хранения максимального числа вхождений
        int maxCount = 0;

        // Цикл по массиву объектов searchables, где count — количество элементов
        for (int i = 0; i < count; i++) {

            // Получаем текущий объект из массива по индексу i
            Searchable item = searchables[i];

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