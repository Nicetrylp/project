package service;

import dao.BookDao;
import domain.Book;
import domain.PageBean;
import java.util.List;

public class BookService {
    private static BookDao bookDao = new BookDao();


    public PageBean<Book> select(String pc,String sql) {
        int p = setPc(pc);
        String countSql = "select count(*) from book";
        countSql +=sql;
        Long aLong = bookDao.selectCount(countSql);
        Number number = aLong;
        int i = number.intValue();
        PageBean<Book> pageBean = new PageBean<>(p,10,i);
        sql+=" limit "+pageBean.getStartIndex()+","+pageBean.getPageSize();
        String bookSql = "select * from book";
        bookSql +=sql;
        List<Book> books = bookDao.selectBySql(bookSql);
        pageBean.setList(books);
        return pageBean;
    }

    private int setPc(String pc){
        if (pc == null){
            pc = "1";
        }else if (pc.equals("")){
            pc = 1+pc;
        }
        int p = Integer.parseInt(pc);
        return p;
    }
}
