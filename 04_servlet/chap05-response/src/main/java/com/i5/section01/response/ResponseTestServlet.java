package com.i5.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/*
 *   ResponseTestServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 5.
 **/
@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();  // 10버전 이후로는 출력 전이면 스트림을 생성한 이후 타입을 설정해도 된다.
        resp.setContentType("text/html; charset=utf-8"); // 이렇게 순서를 바꿔도 가능하다는 말이다.

        System.out.println(resp.getContentType());
        System.out.println(resp.getCharacterEncoding());
//        resp.setCharacterEncoding("UTF-8");
        out.println("hello world");

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>안녕? servlet response</h1>\n")
                .append("</body>\n")
                .append("</html>");

        out.println(responseBuilder);
        out.flush(); // flush는 버퍼에 들어있는 내용을 싹 밀어내준다.
        out.close(); // close는 flush를 자동으로 실행해줘서 flush 생략 가능
        out.println(responseBuilder);
    }
}
