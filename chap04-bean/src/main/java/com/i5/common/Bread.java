package com.i5.common;

import java.util.Date;

/*
 *   Bread.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/
public class Bread extends Product {

    private java.util.Date bakedDate;

    public Bread() {}

    public Bread(String name, int price, java.util.Date bakedDate) {

        // 부모 생성자
        super(name, price);
        this.bakedDate = bakedDate;
    }

    public Date getBakedDate() {
        return bakedDate;
    }

    public void setBakedDate(Date bakedDate) {
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {

        return super.toString() + " " + this.bakedDate;
    }
}
