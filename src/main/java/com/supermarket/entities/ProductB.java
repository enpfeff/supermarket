package com.supermarket.entities;

/**
 * Created by ian on 3/3/15.
 */
public class ProductB implements Product, IHasDiscount {

    // If you were to go beyond use spring to initalize as beans with a constructor using a UUID and price variable
    // in a clientMainConfig.xml

    // As Product B is discounted have it implement IHasDiscount and give it the appropiate variables
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

    // Override the equals and Hashcode to determine equallity in the ShoppingCart Entity so we can use Sets
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
