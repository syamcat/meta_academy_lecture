package com.i5.section01.autowired.subsection01.field;

/*
 *   BookService.java
 *   Author : syamcat
 *   Created : 24. 6. 20.
 **/

import org.springframework.beans.factory.annotation.Autowired;
import com.i5.section01.autowired.common.BookDAO;
import org.springframework.stereotype.Service;
import com.i5.section01.autowired.common.BookDTO;

import java.util.List;

@Service("bookServiceField")
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public List<BookDTO> findAllBooks() {
        return bookDAO.findAllBooks();
    }

    public BookDTO findBookBySeq(int seq) {

        return bookDAO.findBookBySequence(seq);
    }
}
