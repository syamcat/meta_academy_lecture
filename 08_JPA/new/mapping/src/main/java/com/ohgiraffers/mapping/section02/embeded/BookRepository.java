package com.ohgiraffers.mapping.section02.embeded;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager manager;

    public void save(Book book) {
        manager.persist(book);  // book 클래스 대로 영속화
    }
}
