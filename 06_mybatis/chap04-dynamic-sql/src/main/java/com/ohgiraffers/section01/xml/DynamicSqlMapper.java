package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DynamicSqlMapper {

    // key:value형태의 객체만 주고 받을 수 있다. 그냥 Integer객체로는 안됨!
    List<MenuDTO> findMenuByPrice(Map<String, Integer> map);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByRandomMenuCode(Map<String, List<Integer>> criteria);

    List<MenuDTO> searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> criteria);
    int modifyMenu(Map<String , Object> criteria);
}
