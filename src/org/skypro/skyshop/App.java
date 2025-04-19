package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket(10);
        Product simpleProduct1 = new SimpleProduct("tomato", 100);
        Product simpleProduct2 = new SimpleProduct("potato", 50);
        Product simpleProduct3 = new SimpleProduct("milk", 70);
        Product discountedProduct1 = new DiscountProduct(70, 15, "cheese");
        Product discountedProduct2 = new DiscountProduct(50, 30, "apple");
        Product fixPriceProduct1 = new FixPriceProduct("carrot");
        Product fixPriceProduct2 = new FixPriceProduct("chocolate");
        Product fixPriceProduct3 = new FixPriceProduct("yogurt");
        basket.addProduct(simpleProduct1);
        basket.addProduct(simpleProduct2);
        basket.addProduct(simpleProduct3);
        basket.addProduct(discountedProduct1);
        basket.addProduct(discountedProduct2);
        basket.addProduct(fixPriceProduct1);
        basket.addProduct(fixPriceProduct2);
        basket.addProduct(fixPriceProduct3);
        basket.printBasketContents();
        boolean result1 = basket.checkProduct(discountedProduct1);
        boolean result2 = basket.checkProduct(fixPriceProduct2);
        System.out.println(result1);
        System.out.println(result2);
        basket.clearBasket();
        basket.printBasketContents();
        boolean result3 = basket.checkProduct(simpleProduct3);
        System.out.println(result3);
    }
}



