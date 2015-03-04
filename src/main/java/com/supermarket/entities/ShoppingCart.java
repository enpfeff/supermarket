package com.supermarket.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ian on 3/3/15.
 * This object will hold all Products and have methods to sort through the cart
 */
public class ShoppingCart {

    private List<Product> products;

    // standard constructor
    public ShoppingCart() {
        if (products == null) {
            products = new ArrayList<>();
        }
    }

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        if (products != null) {
            products.add(product);
        } else {
            System.err.println("Shopping Cart is not initialized");
        }
    }

    public Set<Product> getUniqueProductsInList() {
        // sets only have unique elements using the equals and hascode overrides
        return new HashSet<>(getProducts());
    }

    public int getNumberOfSpecificProduct(Class className) throws ClassNotFoundException {
        int count = 0;
        // probably a better way
        for (Product product : getProducts()) {
            if (product.getClass() == className) {
                count += 1;
            }
        }
        return count;
    }

    public void removeProduct(Product product) {
        if (products != null) {
            products.remove(product);
        } else {
            System.err.println("Shopping Cart is not initialized");
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
