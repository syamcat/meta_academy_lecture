package com.i5.section02.javaconfig;

import com.i5.section01.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *   Application.java
 *   Author : syamcat
 *   Created : 24. 6. 19.
 **/
public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // name = function name or modified by Annotation
        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println("member = " + member);
    }
}
