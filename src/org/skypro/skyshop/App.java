package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;


public class App {
    public static void main(String[] args) {

        Product phone = new SimpleProduct("Телефон", 15000);
        Product laptop = new DiscountProduct("Ноутбук", 50000, 10);
        Product headphones = new FixPriceProduct("Наушники");
        System.out.println(phone);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(phone);
        basket.addProduct(laptop);
        basket.addProduct(headphones);

        System.out.println("Удаление 'Телефон':");
        List<Product> removedPhones = basket.removeByName("Телефон");
        System.out.println("Удалено продуктов: " + removedPhones.size());
        for (Product p : removedPhones) {
            System.out.println("Удалён: " + p.toString());
        }
        System.out.println("\nСодержимое корзины:");
        basket.printBasketContents();

        System.out.println("\nУдаление 'Монитор':");
        List<Product> removedUnknown = basket.removeByName("Монитор");
        if (removedUnknown.isEmpty()) {
            System.out.println("Список пуст");
        }
        System.out.println("\nСодержимое корзины:");
        basket.printBasketContents();

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(phone);
        searchEngine.add(laptop);
        searchEngine.add(headphones);
        searchEngine.add(new Article("Обзор телефона", "Телефон имеет отличную камеру."));

        System.out.println("\nПоиск по 'телефон':");
        List<Searchable> results = searchEngine.search("телефон");
        for (Searchable item : results) {
            System.out.println(item.getStringRepresentation());
        }
    }
}
