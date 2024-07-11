package com.i5.handlermethod;

/*
 *   FirstController.java
 *   Author : syamcat
 *   Created : 24. 7. 10.
 **/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@RequestMapping("/first/*")
public class FirstController {

    // /first/regist 요청이 들어오면
    // void 메소드인 경우 요청 주소가 곹 view의 이름이 된다.
    // return "/first/regist"를 작성해주는 것과 같다.
    @GetMapping("regist")
    public void regist() {}


    /*
    * 1. WebRequst로 요청 파라미터 전달 받기
    * */
    @PostMapping("regist")
    public String registMenu(Model model, WebRequest request) {

        String menuName = request.getParameter("menuName");
        int menuPrice = Integer.parseInt(request.getParameter("menuPrice"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = menuName + "을 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 " + menuPrice +"원으로 등록하였습니다";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void modify() {}

    //@RequstParam("html에서 작성한 변수명") 원래는 이렇게 작성해야한다. 다르면 400번 에러가 발생
    @PostMapping("modify")                // @RequestParam(required = false) == not Null = false
    public String modifyMenuPrice(Model model, @RequestParam(required = false) String modifyName, @RequestParam(defaultValue = "0") int modifyPrice) {


        System.out.println("modifyName: " + modifyName);
        System.out.println("modifyPrice: " + modifyPrice);

        String message = modifyName  + "메뉴 가격을" + modifyPrice + "원으로 변경하였습니다.";

        model.addAttribute("message", message);
        return "first/messagePrinter";
    }

    @PostMapping("modifyAll")                       //Map은 컴파일 에러 없이 런타임 에러만 발생시키므로 사용을 지양할 것
    public String modifyAll(Model model, @RequestParam Map<String, String> parameters) {

        String modifyName = parameters.get("modifyName2");
        int modifyPrice = Integer.parseInt(parameters.get("modifyPrice2"));

        String message = "메뉴의 이름을 " + modifyName + "(으)로, 가격을 " +  modifyPrice + "원 으로 변경하였습니다";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void search() {}

    @PostMapping("search")
    public String searchMenu(@ModelAttribute("menu") MenuDTO menu) {
        System.out.println(menu);
        return "first/searchResult";
    }

    @GetMapping("login")
    public void login() {

    }
}
