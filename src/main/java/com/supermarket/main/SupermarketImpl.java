package com.supermarket.main;

import com.supermarket.entities.ProductA;
import com.supermarket.entities.ProductB;
import com.supermarket.entities.ProductC;
import com.supermarket.entities.ShoppingCart;
import com.supermarket.services.CheckoutService;

import java.util.Scanner;

/**
 * Created by enpfeff on 3/3/15.
 */
public class SupermarketImpl implements Supermarket {

    private ShoppingCart shoppingCart;
    private CheckoutService checkoutService;

    public SupermarketImpl() {
        shoppingCart = new ShoppingCart();
        checkoutService = new CheckoutService();
    }

    public static void main(String[] args) {
        // Initialization
        Supermarket supermarket = new SupermarketImpl();
        String input;

        //get input
        if (args == null) {
            // use the argument input
            input = args[0];
        } else {
            // Read input from user
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter Products as a string e.g.(AABBCA)");
            input = scanner.nextLine();
        }
        System.out.println("Total is: " + supermarket.checkout(input) + "$");
    }


    @Override
    public int checkout(String items) {
        //normalize input
        char[] charInputs = items.toLowerCase().toCharArray();
        //add to shoppingCart
        for (char productId : charInputs) {
            switch (productId) {
                case 'a':
                    shoppingCart.addProduct(new ProductA());
                    break;
                case 'b':
                    shoppingCart.addProduct(new ProductB());
                    break;
                case 'c':
                    shoppingCart.addProduct(new ProductC());
                    break;
                default:
                    System.err.println("Product: " + productId + " does not exist, ignoring");
            }
        }

        //checkout
        return checkoutService.checkout(shoppingCart);

    }
}
