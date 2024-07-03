package com.i5.section02.preparedstatement;

import com.i5.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.i5.common.Template.close;
import static com.i5.common.Template.getConnection;

/*
 *   Application2.java
 *   Author : syamcat
 *   Created : 24. 7. 3.
 **/
public class Application2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 사원의 이름이 포함된 글자를 입력하세요: ");
        String name = sc.nextLine();
        List<EmployeeDTO> employees = null;

        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;
//        EmployeeDTO selectedEmp = null;

        try {
            String query = "SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE ?"; // ? 만 박아두고 %는 나중에(setString)때 사용하면 된다!!!
//            String query = "SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE '%" + name + "%'";
//            String sql = "SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE '%중%'";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + name + "%");

            rset = pstmt.executeQuery();
//            System.out.println("rset = " + rset);

//            rset.next();
//            EmployeeDTO selectedEmp = new EmployeeDTO();
//            selectedEmp.setEmpName(rset.getString("EMP_NAME"));
//            selectedEmp.setEmpId(rset.getString("EMP_ID"));
//            System.out.println(selectedEmp);
            employees = new ArrayList<>();
            while (rset.next()) {
                EmployeeDTO selectedEmp = new EmployeeDTO();
                selectedEmp.setEmpName(rset.getString("EMP_NAME"));
                selectedEmp.setEmpId(rset.getString("EMP_ID"));
                employees.add(selectedEmp);
            }

            employees.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(pstmt);
            close(rset);
        }
    }
}
