package org.skypro.skyshop.product;

public abstract class Product {
    private String productName;
    public abstract int getProductCost();

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
    public boolean isSpecial() {
        return false;
    }

}

