package com.i5.common;

import java.util.ArrayList;

/*
 *   ShoppingCart.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/

import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private final List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product item) {
        items.add(item);
    }

    public List<Product> getItems() {
        return items;
    }
}
