package com.nicetry.bookstore.admin.admin.web;

import com.nicetry.bookstore.admin.admin.domain.Admin;
import com.nicetry.bookstore.admin.admin.service.AdminService;
import com.nicetry.bookstore.admin.admin.service.exception.LoginException;
import com.nicetry.bookstore.util.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends BaseServlet{
    AdminService adminService = new AdminService();
    public String login(HttpServletRequest request, HttpServletResponse response){
        Map<String, String[]> parameterMap = request.getParameterMap();
        Admin admin = new Admin();
        try {
            BeanUtils.populate(admin,parameterMap);
            adminService.login(admin);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            request.setAttribute("msg",e.getMessage());
            return "f:";
        }
        request.getSession().setAttribute("adminName",admin.getAdminName());
        return "r:/adminjsps/admin/index.jsp";
    }
}
