package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] products;

    public ProductBasket(int size) {
        this.products = new Product[size];
    }

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public void printBasketContents() {
        int totalCost = 0;
        boolean isEmpty = true;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i].getProductName() + ": " + products[i].getProductCost());
                totalCost = totalCost + products[i].getProductCost();
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");
            System.out.println("Итого: " + totalCost);
        } else {
            System.out.println("Итого: " + totalCost);
        }
    }

    public boolean checkProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getProductName().equals(product.getProductName())) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Arrays.fill(products, null);
    }
}

