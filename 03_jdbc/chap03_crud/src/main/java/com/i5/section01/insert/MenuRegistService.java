package com.i5.section01.insert;

import com.i5.model.dto.MenuDTO;

import java.sql.Connection;

import static com.i5.common.Template.*;

/*
 *   MenuRegistService.java
 *   Author : syamcat
 *   Created : 24. 7. 3.
 **/

// Service
// 주 역할: 트랜젝션 담당.
// 하나의 트랜젝션은 하나의 Connection을 가진다.
public class MenuRegistService {

    public boolean registMenu(MenuDTO menu) {

        Connection con = getConnection();

        MenuDAO menuDAO = new MenuDAO();
        int result = menuDAO.insertMenu(con, menu);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result > 0;
    }
}
