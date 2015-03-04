package com.supermarket.entities;

/**
 * Created by ian on 3/3/15.
 */
public class ProductC implements Product {

    // If you were to go beyond use spring to initalize as beans with a constructor using a UUID and price variable
    // in a clientMainConfig.xml
    private double signiture = 3;
    private int price = 30;

    @Override
    public int getPrice() {
        return price;
    }

    // Override the equals and Hashcode to determine equallity in the ShoppingCart Entity so we can use Sets
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductC)) return false;

        ProductC productC = (ProductC) o;

        if (price != productC.price) return false;
        if (Double.compare(productC.signiture, signiture) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(signiture);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + price;
        return result;
    }
}
