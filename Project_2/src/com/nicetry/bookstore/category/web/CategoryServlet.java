package com.nicetry.bookstore.category.web;

import com.nicetry.bookstore.category.service.CategoryService;
import com.nicetry.bookstore.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@WebServlet(name = "CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends BaseServlet {
    /**
     * 查询所有分类
     * @param request
     * @param response
     * @return
     */
    CategoryService categoryService = new CategoryService();
    public String queryAll(HttpServletRequest request, HttpServletResponse response){
        List<String> list = categoryService.queryAll();
        request.setAttribute("category",list);
        return "f:/jsps/left.jsp";
    }
    public String queryByCategory(HttpServletRequest request, HttpServletResponse response){
        return "";
    }
}
