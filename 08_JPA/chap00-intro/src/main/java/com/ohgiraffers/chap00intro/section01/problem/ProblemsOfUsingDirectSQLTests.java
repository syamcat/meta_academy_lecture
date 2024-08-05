package com.ohgiraffers.chap00intro.section01.problem;

import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemsOfUsingDirectSQLTests {
    private Connection con;


    @BeforeEach
    public void setConnection() throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb";
        String user = "ohgiraffers";
        String password = "ohgiraffers";

        Class.forName(driver);

        con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(false);
    }

    @AfterEach
    public void closeConnection() throws SQLException {
        con.rollback();
        con.close();
    }

    @Test
    public void testConnection() {
        Assertions.assertNotNull(con);
    }

    @DisplayName("직접 SQL을 작성하여 메뉴를 조회할 때 발생하는 문제 확인")
    @Test
    public void testDirectSelectionSQL() throws SQLException {

        // given
        String query = "SELECT MENU_CODE, MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS FROM TBL_MENU";

        // when
        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<Menu> menus = new ArrayList<>();
        while(rset.next()) {
            Menu menu = new Menu();
            menu.setMenuCode(rset.getInt("MENU_CODE"));
            menu.setMenuName(rset.getString("MENU_NAME"));
            menu.setMenuPrice(rset.getInt("MENU_PRICE"));
            menu.setCategoryCode(rset.getInt("CATEGORY_CODE"));
            menu.setOrderableStatus(rset.getString("ORDERABLE_STATUS"));

            menus.add(menu);
        }

        // then(verify)
        Assettions.assetNotNull(menus);


        @DisplayName("직접 SQL을 작성하여 신규 메뉴를 추가 시 발생하는 문제 확인")
        @Test
        public void testDirectInsertSQL() {

            Menu menu = new Menu();
            menu.setMenuName("멸치알퀘이크");
            menu.setMenuPrice(10000);
        }

    }
}
