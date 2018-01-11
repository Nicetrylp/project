package com.nicetry.bookstore.book.web;

import com.nicetry.bookstore.book.domain.Book;
import com.nicetry.bookstore.book.service.BookService;
import com.nicetry.bookstore.util.BaseServlet;
import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BaseServlet{
    private static BookService bookService = new BookService();


    /**
     * 查询所有图书
     * @param request
     * @param response
     * @return
     */
    public String queryAll(HttpServletRequest request, HttpServletResponse response){
        List<Book> books = bookService.queryAll();
        request.setAttribute("books",books);
        JSONArray jsonArray = JSONArray.fromObject(books);
        try {
            response.getWriter().write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return "f:/jsps/main.jsp";
        return "f:/jsps/book/list.jsp";
    }

    /**
     * 根据类型查询书籍
     * @param request
     * @param response
     * @return
     */
    public String queryByCategory(HttpServletRequest request, HttpServletResponse response){
        String category = request.getParameter("category");
        List<Book> books = bookService.queryByCategory(category);
        request.setAttribute("books",books);
        return "f:/jsps/book/list.jsp";
    }

    public String queryByBookName(HttpServletRequest request, HttpServletResponse response){
        String bookname = request.getParameter("bookname");
        Book book = bookService.queryByBookName(bookname);
        request.setAttribute("book",book);
        return "f:/jsps/book/desc.jsp";
    }
}
