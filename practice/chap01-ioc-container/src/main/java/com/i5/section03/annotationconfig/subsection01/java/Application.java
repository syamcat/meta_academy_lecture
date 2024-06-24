package com.i5.section03.annotationconfig.subsection01.java;

import com.i5.section01.common.MemberDAO;
import com.i5.section01.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 *   Application.java
 *   Author : syamcat
 *   Created : 24. 6. 19.
 **/
public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
        System.out.println(MemberDAO.findMemberBySeq(1));
        System.out.println(MemberDAO.save(new MemberDTO(3, "user03", "pass03", "신사임당")));
        System.out.println(MemberDAO.findMemberBySeq(3));
    }
}
