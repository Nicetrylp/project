package com.lanou3g.study;

import com.lanou3g.userdao.Database;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class read extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            JSONArray jsonArray = Database.select();
            resp.getWriter().write(jsonArray.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            System.out.println("jinlaile");
            JSONArray jsonArray = Database.select();
            System.out.println(jsonArray.toString());
            resp.getWriter().write(jsonArray.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
