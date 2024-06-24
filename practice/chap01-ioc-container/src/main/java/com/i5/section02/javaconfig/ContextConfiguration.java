package com.i5.section02.javaconfig;

/*
 *   ContextConfiguration.java
 *   Author : syamcat
 *   Created : 24. 6. 19.
 **/

import com.i5.section01.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// spring-context.xml 파일에서 설정한 것과 같은 의미이다.
// 클래스를 Bean으로 인식하게 해주는 어노테이션
@Configuration
public class ContextConfiguration {

    @Bean("member")
    public MemberDTO getMember() {

        System.out.println("getMember 호출함...");

        return new MemberDTO(1, "user01", "pass01", "홍길동");

    }
}
