package com.i5.section01.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/*
 *   ExceptionHandlerServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 5.
 **/
@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Enumeration<String> attrNames = req.getAttributeNames();
        while (attrNames.hasMoreElements()) {
            System.out.println(attrNames.nextElement());
        }


        Integer statusCode = (Integer)req.getAttribute("jakarta.servlet.error.status_code");
        String message = (String)req.getAttribute("jakarta.servlet.error.message");

        System.out.println(statusCode);
        System.out.println(message);

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>" + statusCode + "</h1>\n")
                .append("<h3>" + message + "</h3>\n")
                .append("</body>\n")
                .append("</html>\n");


        out.close();
    }

    // post로 받은 걸 get으로 넘김
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
