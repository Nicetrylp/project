package com.nicetry.bookstore.book.dao;

import com.nicetry.bookstore.book.domain.Book;
import com.nicetry.bookstore.util.DBCPUtil;
import com.nicetry.bookstore.util.LPQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDao {
    public List<Book> queryAll(){
        String sql = "select * from book where del=false";
        List<Book> books = null;
        try {
            books = new LPQueryRunner().query(DBCPUtil.getConnection(),
                    sql,
                    new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public List<Book> queryByCategory(String category) {
        String sql = "select * from book b inner join category c on b.cid=c.cid where c.cname = ? and del=false";
        List<Book> books = null;
        try {
            books = new LPQueryRunner().query(DBCPUtil.getConnection(),
                    sql,
                    new BeanListHandler<Book>(Book.class),
                    category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;

    }

    public Book queryByBookName(String bookName){
        String sql = "select * from book where bname = ? and del=false";
        Book book = null;
        try {
            book = new LPQueryRunner().query(DBCPUtil.getConnection(),
                    sql,
                    new BeanHandler<Book>(Book.class),
                    bookName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book queryByBookId(String bid){
        String sql = "select * from book where bid = ? and del=false";
        Book book = null;
        try {
            book = new LPQueryRunner().query(DBCPUtil.getConnection(),
                    sql,
                    new BeanHandler<Book>(Book.class),
                    bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public int insertBook(Book book) {
        String sql = "insert into book values(?,?,?,?,?,?,false)";
        int i = 0;
        try {
             i = new LPQueryRunner().update(DBCPUtil.getConnection(),
                    sql,
                    book.getBid(),book.getBname(), book.getPrice(), book.getAuthor(),
                    book.getImage(), book.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public int delBookByBid(String bid) {
        String sql = "update book set del = true where bid = ?";
        int i = 0;
        try {
            i = new LPQueryRunner().update(DBCPUtil.getConnection(),
                    sql,
                    bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public void updateBook(Book book) {
        String sql = "update book set bname=?,price=?,author=?,image=?,cid=? where bid =?";
        try {
            new LPQueryRunner().update(DBCPUtil.getConnection(),
                    sql,
                    book.getBname(),book.getPrice(),book.getAuthor(),
                    book.getImage(),book.getCid(),book.getBid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
