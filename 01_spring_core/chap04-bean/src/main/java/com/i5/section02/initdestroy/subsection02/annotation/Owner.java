package com.i5.section02.initdestroy.subsection02.annotation;

/*
 *   Owner.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Owner {

    @PostConstruct
    public void openShop() {
        System.out.println("사장님이 가게 문을 열었습니다. 이제 쇼핑을 시작할 수 있습니다.");
    }

    @PreDestroy
    public void closeShop() {
        System.out.println("사장님이 가게 문을 닫았습니다. 이제 쇼핑을 시작할 수 있습니다.");
    }
}
