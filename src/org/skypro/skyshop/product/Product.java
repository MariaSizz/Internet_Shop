package org.skypro.skyshop.product;

public abstract class Product {
    private String productName;
    public abstract int getProductCost();
    //private int productCost;

    public Product(String productName) {
        this.productName = productName;
        //this.productCost = productCost;
    }

    public String getProductName() {
        return productName;
    }
    public boolean isSpecial() {
        return false;
    }

}

