package com.supermarket.entities;

/**
 * Created by enpfeff on 3/3/15.
 * Interface will determine if the implemented class has a discount and will trigger additional logic during checkout
 */


public interface IHasDiscount {
    public int getDiscountCount();
    public int getDiscountPrice();
}
