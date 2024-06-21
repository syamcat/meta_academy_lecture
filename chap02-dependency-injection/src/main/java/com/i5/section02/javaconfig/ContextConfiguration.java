package com.i5.section02.javaconfig;

/*
 *   ContextConfiguration.java
 *   Author : syamcat
 *   Created : 24. 6. 20.
 **/

import com.i5.common.Account;
import com.i5.common.PersonalAccount;
import com.i5.common.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator() {
        return new PersonalAccount(03, "123456-45-789012");
    }

    @Bean
    public Member memberGenerator() {
//        return new Member(1, "홍길동","010-1234-5678", "hong123@gmail.com", accountGenerator());
        Member member = new Member();
        member.setSequence(1);
        member.setName("이순신");
        member.setPhone("010-1234-5678");
        member.setEmail("lee123@gmail.com");
        member.setPersonalAccount(accountGenerator());
        return member;

    }

}
