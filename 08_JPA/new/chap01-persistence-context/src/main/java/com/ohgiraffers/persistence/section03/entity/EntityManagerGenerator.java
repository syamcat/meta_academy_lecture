package com.ohgiraffers.persistence.section03.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerGenerator {

    // EntityManager DB의 창고 관리인 같은 역할, 관리인 1개당 창고도 1개 생성됨
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("ohgiraffers");

    private EntityManagerGenerator() {}

    public static EntityManager getManagerInstance() {

        return entityManagerFactory.createEntityManager();
    }
}
