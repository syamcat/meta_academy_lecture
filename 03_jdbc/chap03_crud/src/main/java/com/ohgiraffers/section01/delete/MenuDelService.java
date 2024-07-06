package com.ohgiraffers.section01.delete;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

/*
 *   MenuDelService.java
 *   Author : syamcat
 *   Created : 24. 7. 3.
 **/
public class MenuDelService {

    public boolean deleteMenu(MenuDTO menu) {
        Connection con = getConnection();

        MenuDelDAO menuDelDAO = new MenuDelDAO();

        int result = menuDelDAO.delMenu(con, menu);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
        return result > 0;
    }
}
