package com.ohgiraffers.persistence.section01.entitymanager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryGenerator {

    // persistance.xml의 <persistence-unit name="ohgiraggers"> 의 name과 일치시킨다.
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ohgiraffers");

    public static EntityManagerFactory getInstance() {
        return factory;
    }
}
