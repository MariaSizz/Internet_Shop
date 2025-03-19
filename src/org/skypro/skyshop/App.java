package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main (String[] args) {
        ProductBasket basket = new ProductBasket(5);
        Product product1 = new Product("tomato",100);
        Product product2 = new Product("potato",50);
        Product product3 = new Product("milk",70);
        Product product4 = new Product("cheese",200);
        Product product5 = new Product("pumpkin",80);
        Product product6 = new Product("orange",100);
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);
        basket.printBasketContents();
        boolean result1 = basket.checkProduct(product1);
        boolean result6 = basket.checkProduct(product6);
        System.out.println(result1);
        System.out.println(result6);
        basket.clear();
        basket.printBasketContents();
        boolean result2 =basket.checkProduct(product1);
        System.out.println(result2);
    }
}
