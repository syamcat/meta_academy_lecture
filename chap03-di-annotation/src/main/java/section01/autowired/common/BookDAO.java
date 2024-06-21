package section01.autowired.common;

/*
 *   BookDAO.java
 *   Author : syamcat
 *   Created : 24. 6. 20.
 **/


import java.util.List;

public interface BookDAO {

    List<BookDTO> findAllBooks();

    BookDTO findBookBySequence(int seq);


}
