package com.nicetry.dao;

import com.nicetry.bean.Book;
import com.nicetry.util.Jdbc;
import com.nicetry.util.LPQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDao {
    public List<Book> queryALL() throws SQLException {
        List<Book> books = new LPQueryRunner().query(Jdbc.getConn(),
                "select * from book",
                new BeanListHandler<Book>(Book.class)
        );

        return books;
    }
    public Book queryByName(String bookname) throws SQLException {
        Book book = new LPQueryRunner().query(Jdbc.getConn(),
                "select * from book where bookname=?",
                new BeanHandler<Book>(Book.class),
                bookname
        );
        return book;
    }
}
