package com.i5.section03.proxy.subsection02.cglib;

import com.i5.section03.proxy.common.OhgiraffersStudent;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/*
 *   Handler.java
 *   Author : syamcat
 *   Created : 24. 6. 25.
 **/
public class Handler implements InvocationHandler {

    private final OhgiraffersStudent student;

    public Handler(OhgiraffersStudent student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("공부가 너무 하고싶어요");

        method.invoke(student, args);

        System.out.println("왜 벌써 자려구요? 니 렙에 잠이 오니.");

        return proxy;
    }
}
