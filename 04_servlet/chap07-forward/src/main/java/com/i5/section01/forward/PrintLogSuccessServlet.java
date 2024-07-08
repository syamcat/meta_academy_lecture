package com.i5.section01.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/*
 *   PrintLogSuccessServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 8.
 **/

@WebServlet("/print")
public class PrintLogSuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nickName = (String)req.getAttribute("nickName");

        // 응답에 필요한 데이터로 사용자에게 페이지 응답
        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3>" + nickName + "님 환영합니다.</h3>\n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html; charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.println(responseText);
        out.close();
    }
}
