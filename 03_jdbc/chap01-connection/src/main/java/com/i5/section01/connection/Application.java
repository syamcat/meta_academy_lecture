package com.i5.section01.connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 *   Application.java
 *   Author : syamcat
 *   Created : 24. 7. 2.
 **/
public class Application {

    public static void main(String[] args) {
        // finally에서 호출해서 닫아주기 위해 try문 밖에 작성
        Connection con = null;
//        String url = "jdbc:mysql://localhost/employee";
//        String user ="ohgiraffers";
//        String password = "ohgiraffer";

        Properties prop = new Properties();

        try {

            prop.load(
                    new FileReader(
                    "src/main/java/com/i5/section01/connection/jdbc-config.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            // 클래스 동적 로딩, 사용할 드라이버 등록
            // 타 데이터베이스 상용시 이 부분만 수정하면 된다.
            Class.forName(driver);

            con = DriverManager.getConnection(url, user, password);

            System.out.println("connection = " + con);
        } catch (ClassNotFoundException e) {    // Driver 주소가 잘못 되면 발생하는 에러
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if ( con != null) {
                try {
                    con.close();
                } catch (SQLException e) {     // 쿼리문 실행중 문제 발생
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
