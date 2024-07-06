package com.i5.section01.headers;

/*
 *   RequestHeaderPrintServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 5.
 **/

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/headers")
public class RequestHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }

        System.out.println("accept : " + req.getHeader("accept"));
        // 이전 페이지 url 가져오기
        System.out.println("referer : " + req.getHeader("referer"));
        System.out.println("userAgent : " + req.getHeader("user-agent"));
    }
}
