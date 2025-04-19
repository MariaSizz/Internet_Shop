package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int productCost;

    public SimpleProduct(String productName, int productCost) {
        super(productName);
        this.productCost = productCost;
    }
    @Override
    public int getProductCost() {
        return productCost;
    }
    @Override
    public String toString() {
        return getProductName() + ": " + getProductCost();
    }
}
