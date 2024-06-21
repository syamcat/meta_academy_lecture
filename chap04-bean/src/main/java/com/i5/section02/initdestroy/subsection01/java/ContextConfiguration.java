package com.i5.section02.initdestroy.subsection01.java;

import com.i5.common.Beverage;
import com.i5.common.Bread;
import com.i5.common.Product;
import com.i5.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/*
 *   ContextConfiguration.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/

@Configuration
public class ContextConfiguration {

    // Bean 이름은 함수 명으로 저장된다.
    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());

    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 500);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }

    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner() {
        return new Owner();
    }

    /*XML
    * <bean id="owner" class="com.i5.common.Owner" init-method"openShop" destroy-method="closeShop"/>
    * */
}
