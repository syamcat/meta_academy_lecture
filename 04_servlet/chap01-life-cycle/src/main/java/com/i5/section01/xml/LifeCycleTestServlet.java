package com.i5.section01.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 *   LifeCycleTsetServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 5.
 **/
public class LifeCycleTestServlet extends HttpServlet {

    private int initCount = 1;
    private int getCount = 1;
    private int destroyCount = 1;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("xml 매핑 init() 메소드 호출 : " + initCount++);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("xml 매핑 service() 메소드 호출 : " + getCount++);
    }

    @Override
    public void destroy() {
        System.out.println("xml 매핑 destroy() 메소드 호출 : " + destroyCount++);
    }
}
