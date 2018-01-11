package com.nicetry.bookstore.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        String methodname = req.getParameter("method");
        Class<? extends BaseServlet> servlet = this.getClass();
        Method method = null;
        try {
            method = servlet.getMethod(methodname, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("方法名不存在");
        }
        try {
            String invoke = (String) method.invoke(this, req, resp);
            if (invoke==null || invoke.equals("")){
                return;
            }
            String[] split = invoke.split(":");
            String type = split[0];
            String path = split[1];
            if (type.equals("f")){
                // 请求转发
                req.getRequestDispatcher(path).forward(req,resp);
            }
            if (type.equals("r")){
                // 重定向
                resp.sendRedirect(req.getContextPath()+path);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
