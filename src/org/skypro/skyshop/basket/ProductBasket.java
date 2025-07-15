package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private Map<String, List<Product>> productsMap = new HashMap<>();

    public void addProduct(Product product) {
        String name = product.getName();
        if (!productsMap.containsKey(name)) {
            productsMap.put(name, new ArrayList<>());
        }

        productsMap.get(name).add(product);
    }

    public void printBasketContents() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int totalCost = 0;
        int specialCount = 0;

        for (List<Product> values : productsMap.values()) {
            for (Product p : values) {
                System.out.println(p.toString());

                totalCost += p.getPrice();
                if (p.isSpecial()) {
                    specialCount += p.getPrice();
                }
            }
        }

        System.out.println("Итого: " + totalCost);
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String productName) {
        return productsMap.containsKey(productName);
    }

    public void clearBasket() {
        productsMap.clear();
    }

    public List<Product> removeByName(String name) {
        return productsMap.remove(name);
    }
}
