package com.i5.section01.insert;

import com.i5.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.i5.common.Template.close;

/*
 *   MenuDAO.java
 *   Author : syamcat
 *   Created : 24. 7. 3.
 **/
public class MenuDAO {

    //JPA 스타일
//    public int save() {}
    // my batis 스타일
    public int insertMenu(Connection con, MenuDTO menu) {

        PreparedStatement pstmt = null;
        int result = 0;


        // query 문은 띄어쓰기 조심!!!
        String query = "INSERT INTO TBL_MENU(MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS)"
                + " VALUES (?, ?, ?, ?)";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menu.getMenuName());
            pstmt.setDouble(2, menu.getMenuPrice());
            pstmt.setInt(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderableStatus());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

}
