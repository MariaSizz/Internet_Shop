package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printBasketContents() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int totalCost = 0;
        int specialCount = 0;

        for (Product p : products) {
            System.out.println(p.toString());
            totalCost += p.getPrice();
            if (p.isSpecial()) {
                specialCount += p.getPrice();
            }
        }
        System.out.println("Итого: " + totalCost);
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String productName) {
        for (Product p : products) {
            if (p.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();//позволяет пробежаться по всем элементам
        while (iterator.hasNext()) {
            Product p = iterator.next();//возвращает элемент коллекции
            if (p.getName().equals(name)) {
                removedProducts.add(p);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}
