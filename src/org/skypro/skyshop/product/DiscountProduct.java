package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
    private int baseCost;
    private int discountPercent;

    public DiscountProduct(int baseCost, int discountPercent, String productName) {
        super(productName);
        this.baseCost = baseCost;
        this.discountPercent = discountPercent;

    }

    @Override
    public int getProductCost() {
        return baseCost - (baseCost * discountPercent / 100);
    }
    @Override
    public boolean isSpecial() {
        return true; // Товар со скидкой — специальный
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getProductCost() + " (" + discountPercent + "%)";
    }
}
