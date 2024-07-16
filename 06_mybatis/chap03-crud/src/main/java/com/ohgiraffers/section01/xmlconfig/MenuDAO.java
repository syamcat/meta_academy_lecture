package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {


    public List<MenuDTO> findAllMenus(SqlSession sqlSession) {

        return sqlSession.selectList("MenuMapper.findAllMenus");
    }

    public MenuDTO findMenuByMenuCode(SqlSession sqlSession, int menuCode) {

        return sqlSession.selectOne("MenuMapper.findMenuByMenuCode", menuCode);
    }

    public int registMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.insert("MenuMapper.registMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {

        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.delete("MenuMapper.deleteMenu", menu);
    }
}
