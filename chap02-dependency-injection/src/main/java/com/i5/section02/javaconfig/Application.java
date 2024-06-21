package com.i5.section02.javaconfig;

import com.i5.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 *   Application.java
 *   Author : syamcat
 *   Created : 24. 6. 20.
 **/
public class Application {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Member member = context.getBean(Member.class);

        System.out.println(member.getPersonalAccount().deposit(50000));
        System.out.println(member.getPersonalAccount().getBalance());
        System.out.println(member.getPersonalAccount().withdraw(20000));
        System.out.println(member.getPersonalAccount().getBalance());
    }
}
