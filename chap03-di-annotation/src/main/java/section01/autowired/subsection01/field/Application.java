package section01.autowired.subsection01.field;

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
                new AnnotationConfigApplicationContext("com.i5.section01");

        BookService bookService = (BookService) context.getBean("bookServiceField");

        bookService.findAllBooks().forEach(System.out::println);



    }
}
