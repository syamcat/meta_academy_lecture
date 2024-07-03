package com.i5.section03.sqlinjection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.i5.common.Template.getConnection;

/*
 *   Application1.java
 *   Author : syamcat
 *   Created : 24. 7. 3.
 **/
public class Application1 {

    private static String empId = "200";
    private static String empName = "홍길동";

    public static void main(String[] args) {

        Connection con = getConnection();

        Statement stmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'AND EMP_NAME = '" + empName + "'";
        System.out.println(query);

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if (rset.next()) {
                System.out.println(rset.getString("EMP_NAME") + "님 환영합니다.");
            } else {
                System.out.println("회원정보가 없습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
