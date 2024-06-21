package com.i5.section02.annotation.common;

import org.springframework.stereotype.Component;

/*
 *   Pikachu.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/
@Component
public class Pikachu implements Pokemon {

    @Override
    public void attack() {
        System.out.println("피카츄 백만볼트!! ++");
    }

}
