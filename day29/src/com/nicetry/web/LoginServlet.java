package com.nicetry.web;

import com.nicetry.bean.User;
import com.nicetry.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = UserDao.selectServlet(username);
            if (user != null && user.getPassword().equals(password)){
                System.out.println("登录成功");
                getServletContext().setAttribute("user",user);
                response.sendRedirect("http://localhost:8080");
            }else{
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
                requestDispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
