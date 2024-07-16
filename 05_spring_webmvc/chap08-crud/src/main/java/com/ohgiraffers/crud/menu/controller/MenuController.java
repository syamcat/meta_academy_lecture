package com.ohgiraffers.crud.menu.controller;


import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

// Controller 어노테이션 작성
@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;
    public final MessageSource messageSource;   // 중요하진 않음

    // 생성자에는 Service랑 Source만 담아주기
    public MenuController(MenuService menuService, MessageSource messageSource) {
        this.menuService = menuService;
        this.messageSource = messageSource;
    }

    @GetMapping("list")
    public String findMenuList(Model model) {

        List<MenuDTO> menuList = menuService.findAllMenu();
        model.addAttribute("menuList", menuList);

        return "menu/list";
    }

//    @GetMapping(value="category", produces = "application/json; charset=UTF-8")
//    @ResponseBody
//    public List<CategoryDTO> findAllCategories() { return menuService.findAllCategories(); }

    @PostMapping("regist")
    public String registMenu(MenuDTO newMenu, RedirectAttributes rttr, Locale locale) {

        // Service로 새로운 메뉴 DB에 저장하기
        menuService.registNewMenu(newMenu);
        // rttr에 넘어갈 페이지와 메세지 작성 message_ko_KO.properties 값도
        rttr.addFlashAttribute("successMessage", messageSource.getMessage("registMenu", null, locale));

        // redirect할 화면 작성
        return "redirect:/menu/list";
    }

    // Get요청 들어왔을 때 처리
    @GetMapping("regist")
    public void registPage() {}
}
