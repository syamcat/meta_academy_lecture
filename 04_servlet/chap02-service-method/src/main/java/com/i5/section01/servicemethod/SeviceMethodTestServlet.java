package com.i5.section01.servicemethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 *   SeviceMethodTestServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 5.
 **/

@WebServlet("/request-service")
public class SeviceMethodTestServlet extends HttpServlet {

    @Override // http가 안 붙은 서블릿, 제일 먼저 실행
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service 메소드 호출");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출...");
    }
}
