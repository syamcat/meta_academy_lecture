package com.i5.section02.template;

import java.sql.Connection;
import static com.i5.section02.template.Template.getConnection;
import static com.i5.section02.template.Template.close;

/*
 *   Application.java
 *   Author : syamcat
 *   Created : 24. 7. 2.
 **/
public class Application {
    public static void main(String[] args) {

        Connection con = getConnection();
        System.out.println("con = " + con);

        close(con);
    }
}
