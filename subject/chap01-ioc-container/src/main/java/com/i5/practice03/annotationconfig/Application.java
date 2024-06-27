package com.i5.practice03.annotationconfig;

import com.i5.common.BoardDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 *   Application.java
 *   Author : syamcat
 *   Created : 24. 6. 20.
 **/
public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        BoardDAO board = context.getBean("boardDAO", BoardDAO.class);
        System.out.println(board.selectBoard(1L));
        System.out.println(board.insertBoard(new BoardDTO(3L,  "스프링 수업 엄청 기다렸어요!", "많은 걸 얻어 갈 수 있는 시간 되면 좋겠어요", "봄이올까요")));
        System.out.println(board.selectBoard(3L));
    }
}
