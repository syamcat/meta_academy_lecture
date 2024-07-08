package com.i5.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 *   CookieHandlerServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 8.
 **/
@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);

//        resp.sendRedirect("redirect");

        // url 재작성
//        resp.sendRedirect("redirect?firstName=" + firstName + "&lastName=" + lastName);

        // cookie 방식
        // 쿠키의 이름은 ascii 문자만을 사용해야 하며, 한 번 설정한 쿠키의 이름은 변경할 수 없다.
        // 쿠키의 이름에는 공백문자와 일부 특수문자를 사용할 수 없다. ( [ ] ( ) = , " \ ? @ : ; 등)
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        // cookie 유효기간 설정 (24시간)
        firstNameCookie.setMaxAge(60 * 60 * 24);
        lastNameCookie.setMaxAge(60 * 60 * 24);

        // redirect 요청 헤더에 cookie 삽입
        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);
        resp.sendRedirect("redirect");

    }
}
