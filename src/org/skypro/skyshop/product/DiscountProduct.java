package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
    private final int basePrice;
    private final int discountPercent;

    public DiscountProduct(String name, int basePrice, int discountPercent) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть больше 0");
        }
        this.basePrice = basePrice;
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть от 0 до 100");
        }
        this.discountPercent = discountPercent;
    }

    @Override
    public boolean isSpecial() {
        return true; // Товар со скидкой — специальный
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discountPercent / 100);
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountPercent + "%)";
    }
}

