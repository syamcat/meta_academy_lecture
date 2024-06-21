package com.i5.section01.xmlconfig;

import com.i5.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 *   Application.java
 *   Author : syamcat
 *   Created : 24. 6. 20.
 **/
public class Application {
    public static void main(String[] args) {

        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/string-context.xml");

        Member member = context.getBean("member", Member.class);

        System.out.println(member.getPersonalAccount().deposit(10000));
        System.out.println(member.getPersonalAccount().getBalance());
        System.out.println(member.getPersonalAccount().withdraw(5000));
        System.out.println(member.getPersonalAccount().getBalance());
    }
}
