package com.i5.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 *   FormDataTestServlet.java
 *   Author : syamcat
 *   Created : 24. 7. 5.
 **/
@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getCharacterEncoding());
//        req.setCharacterEncoding("UTF-8");
        // spring boot 2.7까지는 써줘야함 톰캣 8버전 까지도
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        Map<String, String[]> requestMap = req.getParameterMap();
        Set<String> keysSet = requestMap.keySet();
        Iterator<String> keyIter = keysSet.iterator();

        while(keyIter.hasNext()) {
            String key = keyIter.next();
            String[] values = requestMap.get(key);

            System.out.println("key : " + key);
            for (int i = 0; i < values.length; i++) {
                System.out.println("value : " + values[i]);
            }
        }

        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }
    }
}
