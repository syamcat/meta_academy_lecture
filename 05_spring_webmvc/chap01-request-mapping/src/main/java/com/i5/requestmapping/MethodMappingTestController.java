package com.i5.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.*;

/*
 *   MethodMappingTestController.java
 *   Author : syamcat
 *   Created : 24. 7. 10.
 **/

@Controller
public class MethodMappingTestController {

    @RequestMapping("/menu/regist")
    public String menuRegist(Model model) {

        model.addAttribute("message", "GET 방식의 메뉴 등록용 핸들러 메소드 호출함");
        //internal resource view resolver
        return "mappingResult";

        // original
        // return "templates/mappingResult.html";
    }


    @RequestMapping(value="/menu/modify", method= RequestMethod.GET) // GET방식 요청만 허용
    public String modifyMenu(Model model) {

        model.addAttribute("message", "GET 방식의 메뉴 수정용 핸들러 메소드 호출함...");
        return "mappingResult";
    }


    // 요청 메소드 전용 어노테이션
    /* 요청 메소드   어노테이션
    *  POST       @PostMapping
    *  GET        @GetMapping
    *  PUT        @PutMapping
    *  DELETE     @DeleteMapping
    *  PATCH      @PatchMapping
    * */

}
