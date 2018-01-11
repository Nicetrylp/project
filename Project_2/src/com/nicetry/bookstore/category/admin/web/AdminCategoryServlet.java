package com.nicetry.bookstore.category.admin.web;

import com.nicetry.bookstore.category.admin.service.AdminCategoryService;
import com.nicetry.bookstore.category.admin.service.exception.InsertException;
import com.nicetry.bookstore.category.domain.Category;
import com.nicetry.bookstore.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "AdminCategoryServlet",urlPatterns = "/aCategory")
public class AdminCategoryServlet extends BaseServlet {
    AdminCategoryService adminCategoryService = new AdminCategoryService();
    public String lookCategory(HttpServletRequest request, HttpServletResponse response){
        List<Category> categories = adminCategoryService.queryAll();
        request.setAttribute("aCategory",categories);
        return "f:/adminjsps/admin/category/list.jsp";
    }

    public String addCategory(HttpServletRequest request, HttpServletResponse response) {
        String cname = request.getParameter("cname");
        String cid = UUID.randomUUID().toString().replaceAll("-","");
        Category category = new Category(cid,cname);
        try {
            adminCategoryService.addCategory(category);
        } catch (InsertException e) {
            request.setAttribute("msg",e.getMessage());
            return "f:/adminjsps/admin/category/add.jsp";
        }
        request.setAttribute("msg","添加成功");
        return "f:/adminjsps/admin/category/add.jsp";
    }

    public String modCategory(HttpServletRequest request, HttpServletResponse response){
        String cid = request.getParameter("cid");
        String cname = request.getParameter("cname");
        adminCategoryService.molCategory(cid,cname);
//        lookCategory(request,response);
        return "f:/aCategory?method=lookCategory";
    }

    public String delCategory(HttpServletRequest request, HttpServletResponse response){
        String cid = request.getParameter("cid");
        adminCategoryService.delCategory(cid);
//        lookCategory(request,response);
        return "f:/aCategory?method=lookCategory";
    }
}
