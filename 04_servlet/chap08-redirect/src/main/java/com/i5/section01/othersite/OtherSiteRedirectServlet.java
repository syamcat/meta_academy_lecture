package com.i5.section01.othersite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 *   OtherSiteRedirect.java
 *   Author : syamcat
 *   Created : 24. 7. 8.
 **/

@WebServlet("/othersite")
public class OtherSiteRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("get 요청 후 naver 사이트로 redirect");

        resp.sendRedirect("https://www.naver.com");
    }
}
