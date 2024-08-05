package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager manager;    // 의존성 주입으로 창고랑 관리인 생성!!

    public void save(Member member) {
        manager.persist(member);
    }
}
