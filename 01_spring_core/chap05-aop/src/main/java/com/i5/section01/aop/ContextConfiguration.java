package com.i5.section01.aop;

/*
 *   ContextConfiguration.java
 *   Author : syamcat
 *   Created : 24. 6. 25.
 **/

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextConfiguration {

}
