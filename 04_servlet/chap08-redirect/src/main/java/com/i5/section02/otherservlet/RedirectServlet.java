package com.i5.section02.otherservlet;

/*
 *   RedirectServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 8.
 **/

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    // redirect 방식은 무조건 doGet방식으로 받아야 한다
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("이 서블릿으로 redirect 성공!");
    }
}
