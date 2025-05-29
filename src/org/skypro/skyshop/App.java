package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;


public class App {
    public static void main(String[] args) {
        // Тест 1: Пустое название продукта
        try {
            Product invalidProduct = new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Тест 2: Цена <= 0
        try {
            Product invalidPrice = new SimpleProduct("Телефон", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Тест 3: Некорректный процент скидки
        try {
            Product invalidDiscount = new DiscountedProduct("Ноутбук", 50000, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        // Создаем движок и добавляем объекты
        final Product p = new SimpleProduct("Телефон Samsung", 10000);
        System.out.println(p);
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new SimpleProduct("Телефон Samsung", 10000));
        searchEngine.add(new DiscountedProduct("Телефон Xiaomi", 15000, 20));
        searchEngine.add(new FixPriceProduct("Чехол для телефона"));

        // Сценарий 1: Объект существует
        try {
            Searchable bestMatch = searchEngine.findBestMatch("телефон");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }

        // Сценарий 2: Объект не найден
        try {
            Searchable bestMatch = searchEngine.findBestMatch("несуществующий запрос");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }
}
