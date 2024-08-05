package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {


    public void findMenuByPrice(int price) {

        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);

        List<MenuDTO> menuList = mapper.findMenuByPrice(map);

        sqlSession.close();
        if(menuList != null) {
            if(menuList.size() == 0) {
                System.out.println("검색된 메뉴가 없습니다!");
            } else {
                menuList.forEach(System.out::println);
            }
        } else {
            System.out.println("메뉴 조회를 실패하셨습니다!");
        }
    }

    public void searchMenu(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);
        if(menuList != null) {
            if (menuList.size() == 0) {
                System.out.println("겸색결과가 존재하지 않습니다.");
            } else {
                menuList.forEach(System.out::println);
            }
        } else {
            System.out.println("결과를 불러오지 못했습니다.");
        }
        sqlSession.close();
    }

    public void findMenuBySupCategory(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);

        if(menuList != null) {
            if (menuList.size() == 0) {
                System.out.println("검색결과가 존재하지 않습니다.");
            } else {
                menuList.forEach(System.out::println);
            }
        }else {
            System.out.println("결과를 불러오지 못했습니다.");
        }
        sqlSession.close();
    }

    public void searchByRandomMenuCode(List<Integer> randomMenuCodeList) {

        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, List<Integer>> criteria = new HashMap<>();
        criteria.put("randomMenuCodeList", randomMenuCodeList);

        List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(criteria);
        if(menuList != null) {
            if (menuList.size() == 0) {
                System.out.println("검색결과가 없습니다.");

            } else {
                menuList.forEach(System.out::println);
            }
        } else {
            System.out.println("검색에 실패하셨습니다.");
        }
        sqlSession.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menuList != null) {
            if (menuList.size() == 0) {
                System.out.println("검색 결과가 존재하지 않습니다.");
            } else {
                menuList.forEach(System.out::println);
            }
        } else {
            System.out.println("검색에 실패하셨습니다.");
        }
        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(criteria);
        if(menuList != null) {
            if (menuList.size() == 0) {
                System.out.println("검색 결과가 존재하지 않습니다.");
            } else {
                menuList.forEach(System.out::println);
            }
        } else {
            System.out.println("검색에 실패하셨습니다.");
        }
        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result = mapper.modifyMenu(criteria);
        if(result > 0) {
            System.out.println("메뉴 정보 변경에 성공하셨습니다.");
            sqlSession.commit();
        } else {
            System.out.println("메뉴 정보 변경에 실패 하셨습니다. ");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}
