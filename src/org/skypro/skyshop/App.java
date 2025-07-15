package org.skypro.skyshop;

import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        Product phone = new SimpleProduct("Телефон", 15000);
        Product laptop = new DiscountProduct("Ноутбук", 50000, 10);
        Article article1 = new Article("Обзор телефона", "Телефон имеет отличную камеру.");
        Article article2 = new Article("Как выбрать ноутбук", "Ноутбук должен быть мощным.");

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(phone);
        searchEngine.add(laptop);
        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println("\nПоиск по 'телефон':");
        Set<Searchable> results = searchEngine.search("телефон");
        for (Searchable item : results) {
            System.out.println(item.getStringRepresentation());
        }
    }
}
