package com.supermarket.services;

import com.supermarket.entities.ProductA;
import com.supermarket.entities.ProductB;
import com.supermarket.entities.ProductC;
import com.supermarket.entities.ShoppingCart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ian on 3/3/15.
 */

public class CheckoutServiceTest {

    int i;
    public ShoppingCart shoppingCart1;
    public ShoppingCart shoppingCart2;
    public ShoppingCart shoppingCart3;
    public CheckoutService checkoutService;

    @Before
    public void before(){
        checkoutService = new CheckoutService();

        //Shop 1
        i = 0;
        shoppingCart1 = new ShoppingCart();
        while (i < 3) {
            shoppingCart1.addProduct(new ProductA());
            i++;
        }
        i = 0;
        while (i < 5) {
            shoppingCart1.addProduct(new ProductB());
            i++;
        }
        i = 0;
        while (i < 1) {
            shoppingCart1.addProduct(new ProductC());
            i++;
        }

        //Shop 2
        i = 0;
        shoppingCart2 = new ShoppingCart();
        while (i < 0) {
            shoppingCart2.addProduct(new ProductA());
            i++;
        }
        i = 0;
        while (i < 0) {
            shoppingCart2.addProduct(new ProductB());
            i++;
        }
        i = 0;
        while (i < 1) {
            shoppingCart2.addProduct(new ProductC());
            i++;
        }

        //Shop 3
        i = 0;
        shoppingCart3 = new ShoppingCart();
        while (i < 2) {
            shoppingCart3.addProduct(new ProductA());
            i++;
        }
        i = 0;
        while (i < 15) {
            shoppingCart3.addProduct(new ProductB());
            i++;
        }
        i = 0;
        while (i < 1) {
            shoppingCart3.addProduct(new ProductC());
            i++;
        }
    }

    @Test
    public void testDiscount() {
        Assert.assertEquals(240, checkoutService.checkout(shoppingCart1));
    }

    @Test
     public void testDiscount2() {
        Assert.assertEquals(30, checkoutService.checkout(shoppingCart2));
    }
    @Test
    public void testDiscount3() {
        Assert.assertEquals(520, checkoutService.checkout(shoppingCart3));
    }
}
