package com.i5.section03.proxy.subsection02.cglib;

import com.i5.section03.proxy.common.OhgiraffersStudent;
import org.springframework.cglib.proxy.Enhancer;

/*
 *   Application.java
 *   Author : syamcat
 *   Created : 24. 6. 25.
 **/
public class Application {

    public static void main(String[] args) {
        Handler handler = new Handler(new OhgiraffersStudent());
        OhgiraffersStudent proxy = (OhgiraffersStudent) Enhancer.create(OhgiraffersStudent.class, handler);

        proxy.study(20);
    }

}
