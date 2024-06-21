package com.i5.section01.common;

/*
 *   MemberDAO.java
 *   Author : syamcat
 *   Created : 24. 6. 19.
 **/

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// Database Access Object
@Component
public class MemberDAO {

    // Map <key type, value type>
    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO() {
        memberMap = new HashMap<>();

        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    public static MemberDTO findMemberBySeq(int seq) {
        return memberMap.get(seq);
    }

    public static boolean save(MemberDTO member) {

        int before = memberMap.size();

        memberMap.put(member.getSequence(), member);

        int after = memberMap.size();

        return before < after;
    }
}
