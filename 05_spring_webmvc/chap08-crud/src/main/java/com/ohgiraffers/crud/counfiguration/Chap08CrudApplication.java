package com.ohgiraffers.crud.counfiguration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 아래 두 줄만 작성
@ComponentScan(basePackages = "com.ohgiraffers.crud")
// mapperscan 범위    basePackages=Mapper스캔 범위, annotationClass=스캔하려는 인터페이스명(Mapper만 탐색)
@MapperScan(basePackages = "com.ohgiraffers.crud", annotationClass = Mapper.class)
public class Chap08CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap08CrudApplication.class, args);
    }

}
