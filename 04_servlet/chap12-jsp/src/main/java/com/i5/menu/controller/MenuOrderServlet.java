package com.i5.menu.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 *   MenuOrderServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 9.
 **/
@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 서블릿의 역할
        // 1. 요청 받은 값 확인 및 검증
        // 2. 비지니스 로직 처리 (Application Service쪽의 메소드 호출)
        // 3. 응답 페이지 생성 후 응답 (jsp forward)

        String menuName = req.getParameter("menuName");
        int amount = Integer.parseInt(req.getParameter("amount"));

        // 2
        int orderPrice = 0;
        switch(menuName) {
            case "햄버거" : orderPrice = 6000 * amount; break;
            case "짜장면" : orderPrice = 7000 * amount; break;
            case "짬뽕" : orderPrice = 8000 * amount; break;
            case "순대국" : orderPrice = 9000 * amount; break;
        }

        //3
        req.setAttribute("orderPrice", orderPrice);
        req.setAttribute("menuName", menuName);
        req.setAttribute("amount", amount);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/5_response.jsp");
        dispatcher.forward(req, resp);
    }
}
