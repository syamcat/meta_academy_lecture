package com.i5.practice02.javaconfig;

/*
 *   ContextConfiguration.java
 *   Author : syamcat
 *   Created : 24. 6. 20.
 **/

import com.i5.common.BoardDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean("board")
    public BoardDTO getMember() {
        return new BoardDTO(2L, "스프링 수업이 앞으로 많이 어려워질까요?", "그래도 포기하지 않고 열심히 해볼거예요!", "미래의멋진개발자");
    }
}
