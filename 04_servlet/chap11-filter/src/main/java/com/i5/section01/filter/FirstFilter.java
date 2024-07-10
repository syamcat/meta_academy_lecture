package com.i5.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

/*
 *   FirstFilter.java
 *   Author : syamcat
 *   Created : 24. 7. 9.
 **/

@WebServlet("/first/*")
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter init() 호출...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // servlet 호출 이전 수행할 내용
        System.out.println("Filter doFilter 호출...");

        // 다음 필터의 doFilter 호출(다음 필터가 없는 경우 servlet을 호출)
        filterChain.doFilter(servletRequest, servletResponse);

        // servlet 호출 이후 수행할 내용
        System.out.println("Servlet 요청 수행 완료!");
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter destroy() 호출...");
    }

}
