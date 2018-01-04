package com.nicetry.web;

import com.nicetry.bean.Book;
import com.nicetry.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        String bookname = request.getParameter("bookname");
        try {
            Book book = bookDao.queryByName(bookname);
            request.getServletContext().setAttribute("book_1",book);
            response.sendRedirect("http://localhost:8080/day28/book.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
