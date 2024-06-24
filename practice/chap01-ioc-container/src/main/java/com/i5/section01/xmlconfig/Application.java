package com.i5.section01.xmlconfig;

import com.i5.section01.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 *   Application.java
 *   Author : syamcat
 *   Created : 24. 6. 19.
 **/
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

//        MemberDTO member = (MemberDTO) context.getBean("member");

//        MemberDTO member = context.getBean(MemberDTO.class);

        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println(member);
    }
}
