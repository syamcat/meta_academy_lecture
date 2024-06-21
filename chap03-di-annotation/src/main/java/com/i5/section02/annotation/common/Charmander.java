package com.i5.section02.annotation.common;

import org.springframework.stereotype.Component;

/*
 *   C.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/
@Component
public class Charmander implements Pokemon {

    @Override
    public void attack() {
        System.out.println("파이리 불꽃 공격!!🔥🔥");
    }
}
