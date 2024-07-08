package com.i5.section01.cookie;

/*
 *   RedirectServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 8.
 **/

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("redirect firstName: " + firstName);
        System.out.println("redirect lastName: " + lastName);


        // 요청 헤더에서 쿠키를 불러오는 메서드 getCookies()
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("[cookie]" + cookie.getName() + "=" + cookie.getValue());
        }
    }
}
