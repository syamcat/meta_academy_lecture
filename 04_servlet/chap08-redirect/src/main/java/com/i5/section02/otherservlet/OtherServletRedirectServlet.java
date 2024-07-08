package com.i5.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 *   OtherServletRedirectServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 8.
 **/

@WebServlet("/otherservlet")
public class OtherServletRedirectServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("get 요청 정상 수락");

        // redirect 서블릿으로 redirect
        resp.sendRedirect("redirect");
    }
}
