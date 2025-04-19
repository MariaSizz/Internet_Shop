package org.skypro.skyshop;

import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Создание товаров
        Product simpleProduct = new SimpleProduct("Телефон", 15000);
        Product discountProduct = new DiscountProduct(50000, 10, "Ноутбук");
        Product fixPriceProduct = new FixPriceProduct("Наушники");

        // Создание статей
        Searchable article1 = new Article("Обзор телефона", "Телефон имеет отличную камеру и батарею");
        Article article2 = new Article("Как выбрать ноутбук", "Ноутбук должен быть легким и иметь хорошую батарею");


        SearchEngine searchEngine = new SearchEngine(10);

        // Добавление в SearchEngine
        searchEngine.add(simpleProduct);
        searchEngine.add(discountProduct);
        searchEngine.add(fixPriceProduct);
        searchEngine.add(article1);
        searchEngine.add(article2);

        // Тестирование поиска
        System.out.println("Поиск по 'телефон':");
        Searchable[] results1 = searchEngine.search("телефон");
        System.out.println(Arrays.toString(results1));

        System.out.println("\nПоиск по 'ноутбук':");
        Searchable[] results2 = searchEngine.search("ноутбук");
        System.out.println(Arrays.toString(results2));

        System.out.println("\nПоиск по 'батарею':");
        Searchable[] results3 = searchEngine.search("батарею");
        System.out.println(Arrays.toString(results3));
    }
}



