package com.i5.section03.properties.subsection01.properties;

import com.i5.common.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 *   Application.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/
public class Application {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = context.getBean("carpBread", Product.class);
        System.out.println("carpBread: " + carpBread);

        Product milk = context.getBean("milk", Product.class);
        System.out.println("milk: " + milk);

        Product water = context.getBean("water", Product.class);
        System.out.println("water: " + water);
    }
}
