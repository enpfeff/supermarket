package com.supermarket.entities;

/**
 * Created by enpfeff on 3/3/15.
 */
public class ProductB implements Product, IHasDiscount {

    public static final int DISCOUNT_COUNT = 5;
    public static final int DISCOUT_PRICE = 100;

    private double signiture = 2;
    private int price = 50;

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getDiscountCount() {
        return DISCOUNT_COUNT;
    }

    @Override
    public int getDiscountPrice() {
        return DISCOUT_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductB)) return false;

        ProductB productB = (ProductB) o;

        if (price != productB.price) return false;
        if (Double.compare(productB.signiture, signiture) != 0) return false;

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
