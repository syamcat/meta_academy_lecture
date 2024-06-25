package com.i5.section03.proxy.common;

/*
 *   OhgiraffersStudent.java
 *   Author : syamcat
 *   Created : 24. 6. 25.
 **/
public class OhgiraffersStudent implements Student {

    @Override
    public void study(int hours) {
        System.out.println(hours + "시간 동안 열심히 공부합니다.");
    }
}
