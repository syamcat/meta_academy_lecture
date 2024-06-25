package com.i5.section01.aop;

/*
 *   MemberService.java
 *   Author : syamcat
 *   Created : 24. 6. 25.
 **/

import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.Map;

@Service
public class MemberService {

    private final MemberDAO memberDAO;

    public MemberService(final MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public Map<Long, MemberDTO> findAllMembers() {
        System.out.println("findallMembers()...을 실행했습니다.");
        return memberDAO.findAllMembers();
    }

    public MemberDTO findMemberById( long id) {
        System.out.println("findMemberById()...을 실행했습니다.");

        return memberDAO.findMemberById(id);
    }
}
