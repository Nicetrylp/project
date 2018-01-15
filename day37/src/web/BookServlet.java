package web;

import domain.Book;
import domain.PageBean;
import net.sf.json.JSONObject;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookService",urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    private static BookService bookService = new BookService();
    private String bname;
    private String author;
    private String price;
    private String category;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bname = request.getParameter("bname");
        author = request.getParameter("author");
        price = request.getParameter("price");
        category = request.getParameter("category");
        String pc = request.getParameter("pc");
        String [] strings = {"bname","author","price","category"};
        String [] strings1 = {bname, author, price, category};
        StringBuffer sb = new StringBuffer("");
        if (isTrue()){
            sb.append(" where ");
            boolean showAnd = false;
            for (int i=0;i < strings1.length;i++) {
                if (strings1[i] != null && !strings1[i].equals("")) {
                    if (showAnd) {
                        sb.append(" and ");
                    }
                    sb.append(strings[i] + "=" +"\'"+ strings1[i]+"\'" + " ");
                    showAnd=true;
                }
            }
        }
        PageBean<Book> pageBean = bookService.select(pc, sb.toString());
//        System.out.println(pageBean);
        JSONObject jsonObject = JSONObject.fromObject(pageBean);
        response.getWriter().write(jsonObject.toString());
//        response.sendRedirect("/index.html");
    }

    private boolean isTrue(){
        if (bname!=null && !bname.equals(""))
            return true;
        if (author!=null && !author.equals(""))
            return true;
        if (price!=null && !price.equals(""))
            return true;
        if (category!=null && !category.equals(""))
            return true;
        return false;
    }
}
