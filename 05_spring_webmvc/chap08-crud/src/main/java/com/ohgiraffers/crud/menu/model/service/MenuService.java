package com.ohgiraffers.crud.menu.model.service;

import com.ohgiraffers.crud.menu.model.dao.MenuMapper;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// Service는 Service 어노테이션 작성
@Service
public class MenuService {

    private MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }
    public List<MenuDTO> findAllMenu() { return menuMapper.findAllMenu(); }

    public List<CategoryDTO> findAllCategories() { return menuMapper.findAllCategories(); }

    @Transactional
    public void registNewMenu(MenuDTO newMenu) {
        menuMapper.registNewMenu(newMenu);
    }
}
