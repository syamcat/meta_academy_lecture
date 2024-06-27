package com.i5.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
 *   Squirtle.java
 *   Author : syamcat
 *   Created : 24. 6. 21.
 **/
@Component
@Primary
public class Squirtle implements Pokemon {

    @Override
    public void attack() {
        System.out.println("꼬부기 물대포 공격!!💧💧");
    }
}
