package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;
public abstract class Product implements Searchable {
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
    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

}

