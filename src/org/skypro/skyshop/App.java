package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        // Создание товаров
        Product phone1 = new SimpleProduct("Телефон", 15000);
        Product phone2 = new SimpleProduct("Телефон", 15000);
        Product laptop = new DiscountProduct("Ноутбук", 50000, 10);

        // Создание корзины
        ProductBasket basket = new ProductBasket();
        basket.addProduct(phone1);
        basket.addProduct(phone2);
        basket.addProduct(laptop);

        // Вывод содержимого корзины
        System.out.println("Содержимое корзины:");
        basket.printBasketContents();

        // удаления по имени
        System.out.println("\nУдаление 'Телефон':");
        List<Product> removedPhones = basket.removeByName("Телефон");
        if (removedPhones != null) {
            System.out.println("Удалено продуктов: " + removedPhones.size());
            for (Product p : removedPhones) {
                System.out.println("Удалён: " + p.toString());
            }
        } else {
            System.out.println("Продукт не найден");
        }
        System.out.println("\nСодержимое корзины после удаления:");
        basket.printBasketContents();

        // Создание SearchEngine
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(phone1);
        searchEngine.add(laptop);
        searchEngine.add(new Article("Обзор телефона", "Телефон имеет отличную камеру."));

        // поиск
        System.out.println("\nПоиск по 'телефон':");
        Map<String, Searchable> results = searchEngine.search("телефон");
        for (Map.Entry<String, Searchable> entry : results.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getStringRepresentation());
        }
    }
}
