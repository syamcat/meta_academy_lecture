package com.i5.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

/*
 *   ResponseHeaderPrintServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 5.
 **/
@WebServlet("/headers")
public class ResponseHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
//        resp.setHeader("Refresh", "1"); // 1 초마다 응답.

        PrintWriter out = resp.getWriter();

        long currentTime = System.currentTimeMillis();
        out.println("<h1>" + currentTime + "</h1>");

        out.close();

        Collection<String> responseHeader =  resp.getHeaderNames();

        Iterator<String> iterator = responseHeader.iterator();
        while (iterator.hasNext()) {
            String headerName = iterator.next();
            System.out.println(headerName + ": " + resp.getHeader(headerName));
        }
    }
}
