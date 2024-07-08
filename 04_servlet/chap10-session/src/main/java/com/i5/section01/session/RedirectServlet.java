package com.i5.section01.session;

/*
 *   RedirectServlet.java
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

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // session handler servlet에서 만든 session ID 반환
        HttpSession session = req.getSession();
        System.out.println("session id = " + session.getId());

        String firstName = (String) session.getAttribute("firstName");
        String lastName = (String) session.getAttribute("lastName");

        System.out.println("sesion firstName: " + firstName);
        System.out.println("sesion lastName: " + lastName);
    }
}
