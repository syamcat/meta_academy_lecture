package com.i5.section02.preparedstatement;

import com.i5.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.i5.common.Template.close;
import static com.i5.common.Template.getConnection;

/*
 *   Application1.java
 *   Author : syamcat
 *   Created : 24. 7. 3.
 **/
public class Application1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 사번을 입력하세요: ");
        String empId = sc.nextLine();


        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        EmployeeDTO selectedEmp = null;


        try {
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);

            rset = pstmt.executeQuery();

            while (rset.next()) {
                selectedEmp = new EmployeeDTO();
                selectedEmp.setEmpId(rset.getString("EMP_ID"));
                selectedEmp.setEmpName(rset.getString("EMP_NAME"));
            }
            System.out.println(selectedEmp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(pstmt);
            close(rset);
        }
    }
}
