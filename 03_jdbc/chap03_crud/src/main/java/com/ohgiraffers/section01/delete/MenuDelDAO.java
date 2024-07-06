package com.ohgiraffers.section01.delete;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;

/*
 *   MenuDelDAO.java
 *   Author : syamcat
 *   Created : 24. 7. 3.
 **/
public class MenuDelDAO {

    public int delMenu(Connection con, MenuDTO menu) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = "DELETE FROM TBL_MENU WHERE MENU_NAME = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menu.getMenuName());
//            pstmt.setInt(2, menu.getMenuPrice());
//            pstmt.setInt(3, menu.getCategoryCode());
//            pstmt.setString(4, menu.getOrderableStatus());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }
}
