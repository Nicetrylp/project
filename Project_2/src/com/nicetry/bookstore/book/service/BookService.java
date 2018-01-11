package com.nicetry.bookstore.book.service;

import com.nicetry.bookstore.book.dao.BookDao;
import com.nicetry.bookstore.book.domain.Book;

import java.util.List;

public class BookService {
    private static BookDao bookDao = new BookDao();
    public List<Book> queryAll(){
        List<Book> books = bookDao.queryAll();
        return books;
    }

    public List<Book> queryByCategory(String category){
        List<Book> books = bookDao.queryByCategory(category);
        return books;
    }

    public Book queryByBookName(String bookname) {
        Book book = bookDao.queryByBookName(bookname);
        return book;
    }

    public Book queryByBid(String bid) {
        Book book = bookDao.queryByBookId(bid);
        return book;
    }
}
