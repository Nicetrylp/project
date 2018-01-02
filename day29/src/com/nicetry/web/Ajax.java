package com.nicetry.web;

import com.nicetry.bean.User;
import com.nicetry.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Ajax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 指定允许其他域名访问
        resp.addHeader("Access-Control-Allow-Origin","*");
// 响应类型
        resp.addHeader("Access-Control-Allow-Methods","POST");
// 响应头设置
        resp.addHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        try {
            User user = UserDao.selectServlet(username);
            System.out.println(user);
            if (user == null){
                resp.getWriter().write("true");
            }else{
                resp.getWriter().write("false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
