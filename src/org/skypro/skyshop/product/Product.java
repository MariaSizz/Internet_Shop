package org.skypro.skyshop.product;

public class Product {
    private String productName;
    private int productCost;

    public Product(String productName, int productCost) {
        this.productName = productName;
        this.productCost = productCost;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductCost() {
        return productCost;
    }

    @Override
    public String toString() {
        return productName + ": " + productCost;
    }
}

