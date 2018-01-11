package com.nicetry.bookstore.book.admin.web;

import com.nicetry.bookstore.book.admin.service.AdminBookService;
import com.nicetry.bookstore.book.domain.Book;
import com.nicetry.bookstore.category.admin.service.AdminCategoryService;
import com.nicetry.bookstore.category.domain.Category;
import com.nicetry.bookstore.util.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "AdminBookServlet",urlPatterns = "/aBook")
public class AdminBookServlet extends BaseServlet {
    AdminBookService adminBookService = new AdminBookService();
    public String lookAllBook(HttpServletRequest request, HttpServletResponse response){
        List<Book> books = adminBookService.LookAllBook();
        request.setAttribute("books",books);
        return "f:/adminjsps/admin/book/list.jsp";
    }

    public String loadBook(HttpServletRequest request,HttpServletResponse response){
        AdminCategoryService adminCategoryService = new AdminCategoryService();
        String bid = request.getParameter("bid");
        Book book = adminBookService.loadBookByBid(bid);
        List<Category> categories = adminCategoryService.queryAll();
        request.setAttribute("categories",categories);
        request.setAttribute("book",book);
        return "f:/adminjsps/admin/book/desc.jsp";
    }

    public String addBook(HttpServletRequest request,HttpServletResponse response){
        Book book = createBook(request);
        System.out.println(1);
        adminBookService.addBook(book);
        return "r:/aBook?method=lookAllBook";
    }

    public String loadCategory(HttpServletRequest request,HttpServletResponse response){
        AdminCategoryService adminCategoryService = new AdminCategoryService();
        List<Category> categories = adminCategoryService.queryAll();
        request.setAttribute("categories",categories);
        return "f:/adminjsps/admin/book/add.jsp";
    }

    public String delBook(HttpServletRequest request,HttpServletResponse response){
        String bid = request.getParameter("bid");
        adminBookService.delBook(bid);
        return "r:/aBook?method=lookAllBook";
    }

    public String modBook(HttpServletRequest request,HttpServletResponse response){
        Book book = createBook(request);
//        String bid = request.getParameter("bid");
        adminBookService.modBook(book);
        return "r:/aBook?method=lookAllBook";
    }

    private Book createBook(HttpServletRequest request){

        Map<String, String[]> parameterMap = request.getParameterMap();
        Book book = new Book();
        try {
            BeanUtils.populate(book,parameterMap);
//            book.setImage("book_img/"+book.getImage());
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            book.setBid(uuid);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(book);
        return book;
    }
}
