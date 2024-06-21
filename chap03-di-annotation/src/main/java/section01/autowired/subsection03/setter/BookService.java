package section01.autowired.subsection03.setter;

/*
 *   BookService.java
 *   Author : syamcat
 *   Created : 24. 6. 20.
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import section01.autowired.common.BookDAO;
import section01.autowired.common.BookDTO;

import java.util.List;

@Service("bookServiceSetter")
public class BookService {

    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> findAllBooks() {

        return bookDAO.findAllBooks();
    }

    public BookDTO findBookBySeq(int seq) {

        return bookDAO.findBookBySequence(seq);
    }
}

