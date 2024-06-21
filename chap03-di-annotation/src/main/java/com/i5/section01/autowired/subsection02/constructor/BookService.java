package com.i5.section01.autowired.subsection02.constructor;

/*
 *   BookService.java
 *   Author : syamcat
 *   Created : 24. 6. 20.
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.i5.section01.autowired.common.BookDAO;
import com.i5.section01.autowired.common.BookDTO;

import java.util.List;

@Service("bookServiceConstructor")
public class BookService {

    private final BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> findAllBooks() {

        return bookDAO.findAllBooks();
    }

    public BookDTO findBookBySeq(int seq) {
        return bookDAO.findBookBySequence(seq);
    }
}
