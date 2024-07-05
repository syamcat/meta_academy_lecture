package com.i5.section02.annotation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 *   LifeCycleTEstServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 5.
 **/

@WebServlet(value = "/annotation-lifecycle", loadOnStartup = 1) // value 생략가능
public class LifeCycleTEstServlet extends HttpServlet {

    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("annotation 매핑 init() 메소드 호출 : " + initCount++);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("annotaion 매핑 service() 메소드 호출 : " + serviceCount++);
    }

    @Override
    public void destroy() {
        System.out.println("annotation 매핑 destroy() 메소드 호출 : " + destroyCount++);
    }
}
