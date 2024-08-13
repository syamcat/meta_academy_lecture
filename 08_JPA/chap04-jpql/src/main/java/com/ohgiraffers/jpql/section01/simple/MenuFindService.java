package com.ohgiraffers.jpql.section01.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuFindService {

    private MenuRepository menuRepository;

    @Autowired
    public MenuFindService(MenuRepository menuRepository) {this.menuRepository = menuRepository;}


    public String findMenuNameByMenuCode(int menuCode) {

        return menuRepository.findMenuNameByMenuCode(menuCode);
    }

    public Object findObjectByMenuCode(int menuCode) {

        return menuRepository.findObjectByMenuCode(menuCode);
    }

    public List<Menu> findAllMenusWithTypedQuery() {
        return menuRepository.findAllMenusWithTypedQuery();
    }

    public List<Menu> FindAllMenusWithQuery() {

        return menuRepository.findAllMenusWithQuery();
    }

    public List<Integer> findAllCategoryCodeInMenu() {

        return menuRepository.findAllCategoryCodeInMenu();
    }

    public List<Menu> findAllMenusInCategoryCodes(List<Integer> categoryCodes) {

        return menuRepository.findAllMenusInCategoryCodes(categoryCodes);
    }

    public List<Menu> searchMenusBySearchValue(String searchValue) {

        return menuRepository.searchMenusBySearchValue(searchValue);
    }
}
