package com.i5.section01.aop;

/*
 *   MemberDTO.java
 *   Author : syamcat
 *   Created : 24. 6. 25.
 **/
public class MemberDTO {

    private Long id;
    private String name;

    public MemberDTO() {}

    public MemberDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
