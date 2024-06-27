package com.i5.section01.aop;

/*
 *   MemberDAO.java
 *   Author : syamcat
 *   Created : 24. 6. 25.
 **/

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAO {

    private final Map<Long, MemberDTO> memberMap;


    public MemberDAO() {
        memberMap = new HashMap<>();
        memberMap.put(1L, new MemberDTO(1L, "유관순"));
        memberMap.put(2L, new MemberDTO(2L, "홍길동"));
    }

    public Map<Long, MemberDTO> findAllMembers() {
        return memberMap;
    }

    public MemberDTO findMemberById(Long id) {

        MemberDTO returnMember = memberMap.get(id);

        if (returnMember == null) {
            throw new RuntimeException("해당하는 id의 회원이 없습니다.");
        }

        return returnMember;
    }
}

