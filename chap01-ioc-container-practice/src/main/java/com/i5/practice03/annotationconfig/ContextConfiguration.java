package com.i5.practice03.annotationconfig;

/*
 *   ContextConfiguration.java
 *   Author : syamcat
 *   Created : 24. 6. 20.
 **/

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.i5")
public class ContextConfiguration {
}
