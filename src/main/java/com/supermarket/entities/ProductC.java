package com.supermarket.entities;

/**
 * Created by enpfeff on 3/3/15.
 */
public class ProductC implements Product {

    private double signiture = 3;
    private int price = 30;

    @Override
    public int getPrice() {
        return price;
    }

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
