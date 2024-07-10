package com.i5.requestmapping;

/*
 *   ClassMappingTestController.java
 *   Author : syamcat
 *   Created : 24. 7. 10.
 **/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

    // /order/regist
    @GetMapping("/regist")
    public String registOrder(Model model) {
        model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    @RequestMapping(value={"modify", "delete"}, method= RequestMethod.GET)
    public String modifyAndOrder(Model model) {
        model.addAttribute("message", "GET 방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model, @PathVariable("orderNo") int orderNo) { // @PathVariable로 값을 가져옴

        model.addAttribute("message", orderNo + "번 주문 상세 내용 조회용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    // 접속 주소 localhost:8080/order/test
    @RequestMapping
    public String otherRequest(Model model) {

        model.addAttribute("message", "order 요청이긴 하지만 다른 기능은 아직 준비되지 않음...");

        return "mappingResult";
    }
}
