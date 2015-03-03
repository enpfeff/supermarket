package com.supermarket.entities;

/**
 * Created by enpfeff on 3/3/15.
 */
public class ProductA implements Product {

    // If you were to go beyond use spring to initalize as beans with a constructor using a UUID and price variable
    // in a clientMainConfig.xml

    private double signiture = 1;
    private int price = 20;

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductA)) return false;

        ProductA productA = (ProductA) o;

        if (price != productA.price) return false;
        if (Double.compare(productA.signiture, signiture) != 0) return false;

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
