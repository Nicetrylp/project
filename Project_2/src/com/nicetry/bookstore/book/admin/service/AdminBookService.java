package com.nicetry.bookstore.book.admin.service;

import com.nicetry.bookstore.book.dao.BookDao;
import com.nicetry.bookstore.book.domain.Book;

import java.util.List;

public class AdminBookService {
    BookDao bookDao = new BookDao();
    public List<Book> LookAllBook() {
        List<Book> books = bookDao.queryAll();
        return books;
    }

    public Book loadBookByBid(String bid) {
        Book book = bookDao.queryByBookId(bid);
        return book;
    }

//    public List<Category> loadCategory() {
//        CategoryDao categoryDao = new CategoryDao();
//        List<Category> categories = categoryDao.queryAll();
//        return categories;
//    }

    public void addBook(Book book) {
        if (book == null){
            return;
        }
        int i = bookDao.insertBook(book);
        if (i==1){
            System.out.println("插入成功");
        }
    }

    public void delBook(String bid) {
        int i = bookDao.delBookByBid(bid);
        if (i == 1){
            System.out.println("删除成功");
        }
    }

    public void modBook(Book book) {
        bookDao.updateBook(book);
    }
}
