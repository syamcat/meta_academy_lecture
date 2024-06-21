package com.i5.section03.annotationconfig.subsection01.java;

/*
 *   ContextConfiguration.java
 *   Author : syamcat
 *   Created : 24. 6. 19.
 **/

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.i5")
public class ContextConfiguration {

//    ApplicationContext context =
//            new AnnotationConfigApplicationContext(ContextConfiguration.class);

}
