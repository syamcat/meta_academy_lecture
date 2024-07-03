package com.i5.section03.sqlinjection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.i5.common.Template.getConnection;
import static com.i5.common.Template.close;

/*
 *   Application2.java
 *   Author : syamcat
 *   Created : 24. 7. 3.
 **/
public class Application2 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "empId");
            pstmt.setString(2, "empName");

            rset = pstmt.executeQuery();

            if (rset.next()) {
                System.out.println(rset.getString("EMP_NAME") + "님 환영합니다");
            } else {
                System.out.println("회원정보가 없습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(rset);
            close(pstmt);
        }
    }
}
