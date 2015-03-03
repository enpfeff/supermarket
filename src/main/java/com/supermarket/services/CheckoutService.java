package com.supermarket.services;


import com.supermarket.entities.IHasDiscount;
import com.supermarket.entities.Product;
import com.supermarket.entities.ShoppingCart;

/**
 * Created by enpfeff on 3/3/15.
 * Service and Business Logic for Checkout will determine total price and any associated discounts
 */
public class CheckoutService {

    private int total = 0;

    public int checkout(ShoppingCart shoppingCart) {
        for (Product product : shoppingCart.getProducts()) {
            total += product.getPrice();
        }

        getDiscount(shoppingCart);
        return total;
    }

    public void getDiscount(ShoppingCart cart) {
        int count;
        for (Product product : cart.getUniqueProductsInList()) {
            if (product instanceof IHasDiscount) {
                try {
                    // determine the number of products of this type are in the shopping cart
                    count = cart.getNumberOfSpecificProduct(product.getClass());
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not found");
                    count = 0;
                }
                // if the count is bigger than the definitions for discount count adjust price
                if (count >= ((IHasDiscount) product).getDiscountCount()) {
                    //good ol integer division
                    double multiplier = count / ((IHasDiscount) product).getDiscountCount();
                    total -= (Math.floor(multiplier) * ((IHasDiscount) product).getDiscountPrice());
                }
            }
        }
    }

}
