package com.i5.section02.template;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 *   Template.java
 *   Author : syamcat
 *   Created : 24. 7. 2.
 **/
public class Template {

    public static Connection getConnection() {
        Connection con = null;

        Properties props = new Properties();

        try {
            props.load(
                    new FileReader("src/main/java/com/i5/config/connection-info.properties"));

            String driver = props.getProperty("driver");
            String url = props.getProperty("url");

            Class.forName(driver);

            con = DriverManager.getConnection(url, props);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void close(Connection con) {
        try {
            if (con != null & !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
