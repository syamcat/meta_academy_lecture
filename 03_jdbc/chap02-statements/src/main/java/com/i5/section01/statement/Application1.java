package com.i5.section01.statement;

import com.i5.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static com.i5.common.Template.close;
import static com.i5.common.Template.getConnection;

/*
 *   Application1.java
 *   Author : syamcat
 *   Created : 24. 7. 2.
 **/
public class Application1 {
    public static void main(String[] args) {
        // connection 생성
        Connection con  = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        System.out.println("con=" + con);
        List<EmployeeDTO> empList = null;

        try {
            stmt = con.createStatement();
//            Scanner sc = new Scanner(System.in);
//            System.out.println("조회할 사번을 입력하세요: ");
//            String empId = sc.nextLine();
//            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID='" + empId + "'";
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE";

            // select 시 executeQuery => return type ResultSet
            // insert, update, delete 시 executeUpdate => return type int (변경된 행의 수)
            rset = stmt.executeQuery(query);

//            if (rset.next()) {
//                selectedEmp = new EmployeeDTO();
//                selectedEmp.setEmpId(rset.getString("EMP_ID"));
//                selectedEmp.setEmpName(rset.getString("EMP_NAME"));
//                System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME"));
//            }
            empList = new ArrayList<>();
            while (rset.next()) {
                EmployeeDTO row = new EmployeeDTO();
                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));
                empList.add(row);
//                System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(rset);
            close(stmt);
        }
        empList.forEach(System.out::println);
//        System.out.println(selectedEmp);
    // connection 닫기

    }

}
