package com.i5.section01.session;

/*
 *   SessionHandlerServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 8.
 **/

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);

        // 없으면 세션을 만들어줌
        HttpSession session = req.getSession();
        System.out.println("session id = " + session.getId());

        System.out.println("default session 유지 시간: " + session.getMaxInactiveInterval()); // 기본 세션 만료 설정 30분
        // 10분 뒤 세션 종료 설정
        session.setMaxInactiveInterval(60 * 10);

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        session.invalidate(); // 세션 만료시킴
        // 로그아웃 구현 1. 세션 만료시키기 2. 세션에 유저정보를 null값으로 교체 3. 세션 시간 만료시키기

        resp.sendRedirect("redirect");
    }
}
