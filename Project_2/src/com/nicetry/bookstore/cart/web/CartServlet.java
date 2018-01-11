package com.nicetry.bookstore.cart.web;

import com.nicetry.bookstore.book.domain.Book;
import com.nicetry.bookstore.book.service.BookService;
import com.nicetry.bookstore.cart.domain.Cart;
import com.nicetry.bookstore.cart.domain.CartItem;
import com.nicetry.bookstore.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;


@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends BaseServlet {

    public String cart(HttpServletRequest request, HttpServletResponse response){

        return "r:/jsps/cart/list.jsp";
    }

    public String addCart(HttpServletRequest request, HttpServletResponse response){
        String count = request.getParameter("count");
        String bid = request.getParameter("bid");
        Book book = new BookService().queryByBid(bid);
        int i = Integer.parseInt(count);
            CartItem cartItem = new CartItem(i,book);
            Cart.setCarMap(book.getBid(),cartItem);
            request.getSession().setAttribute("cart",Cart.getCarMap());
        return "r:/jsps/cart/list.jsp";
    }

    public String removeCart(HttpServletRequest request, HttpServletResponse response){
        String bid = request.getParameter("bid");
        HashMap<String,CartItem> cart = (HashMap<String, CartItem>) request.getSession().getAttribute("cart");
        cart.remove(bid);
        request.getSession().setAttribute("cart",cart);
        return "f:/jsps/cart/list.jsp";
    }

    public String cleanCart(HttpServletRequest request, HttpServletResponse response){
        HashMap<String,CartItem> cart = (HashMap<String, CartItem>) request.getSession().getAttribute("cart");
        cart.clear();
        request.getSession().setAttribute("cart",cart);
        return "f:/jsps/cart/list.jsp";
    }
}
