package dao;

import domain.Book;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JDBC;
import util.LPQueryRunner;

import java.sql.SQLException;
import java.util.List;

public class BookDao {
    public void insertBook(Book book){
        String sql = "insert into book values(null,?,?,?,?)";
        try {
            new LPQueryRunner().update(JDBC.getConn(),
                    sql,
                    book.getBname(),book.getAuthor(),
                    book.getPrice(),book.getCategory());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Long selectCount(String countSql) {
        String sql = countSql;
        Long i = 0l;
        try {
            i = new LPQueryRunner().query(JDBC.getConn(),
                    sql, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public List<Book> selectBySql(String sql) {
        List<Book> books = null;
        try {
            books = new LPQueryRunner().query(JDBC.getConn(),
                    sql,
                    new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
