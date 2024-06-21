package com.i5.section03.properties.subsection01.properties;

/*
 *   ContextConfiguration.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/

import com.i5.common.Beverage;
import com.i5.common.Bread;
import com.i5.common.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;

@Configuration
@PropertySource("section03/properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {

    //치환자 문법을 이용하여 properties에 저장된 key를 입력하면 value에 해당하는 값을 꺼내온다.
    //@Value("${bread.carpbread.name:앞내용이 key값에 없는 경우에 default로 들어갈 값 작성}")
    @Value("${bread.carpbread.name:초코맛붕어빵}")
    private String carpBreadName;

//    @Value("${bread.carpbread.price:default값 작성}")
    @Value("${bread.carpbread.price:0}")
    private int carpBreadPrice;

    @Value("${beverage.milk.name}")
    private String milkName;

    @Value("${beverage.milk.price}")
    private int milkPrice;

    @Value("${beverage.milk.capacity}")
    private int milkCapacity;

    @Bean
    public Product carpBread() {
        return new Bread(carpBreadName, carpBreadPrice, new Date());
    }

    @Bean
    public Product milk() {
        return new Beverage(milkName, milkPrice, milkCapacity);
    }

    @Bean
    public Product water(@Value("${beverage.water.name:}") String waterName,
                         @Value("${beverage.water.price:0}") int waterPrice,
                         @Value("${beverage.water.capacity:0}")int waterCapacity) {

        return new Beverage(waterName, waterPrice, waterCapacity);
    }
}

