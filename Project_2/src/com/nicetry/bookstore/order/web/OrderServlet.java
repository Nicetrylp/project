package com.nicetry.bookstore.order.web;

import com.nicetry.bookstore.book.domain.Book;
import com.nicetry.bookstore.cart.domain.CartItem;
import com.nicetry.bookstore.order.dao.Order;
import com.nicetry.bookstore.order.dao.OrderItem;
import com.nicetry.bookstore.order.service.OrderService;
import com.nicetry.bookstore.order.service.exception.ReceiveException;
import com.nicetry.bookstore.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet{
    private static int count = 0;
    private OrderService orderService = new OrderService();
    public String addOrder(HttpServletRequest request, HttpServletResponse response){
        HashMap<String,CartItem> cart = (HashMap<String, CartItem>) request.getSession().getAttribute("cart");
        Order order = createOrder(request);
        orderService.addOrder(order,cart);
        request.setAttribute("order",order);
        Map<String,CartItem> orders = add(cart);
        request.setAttribute("cart",orders);
        cart.clear();
        request.getSession().setAttribute("cart",cart);
        return "f:/jsps/order/desc.jsp";
    }

    public String queryOrderByUser(HttpServletRequest request, HttpServletResponse response){
        String uid = (String) request.getSession().getAttribute("uid");
        Map<Order, Map<OrderItem, Book>> orderListMap = orderService.queryOrderByUser(uid);
        request.setAttribute("orderListMap",orderListMap);
        return "f:/jsps/order/list.jsp";
    }

    public String queryOrderByOid(HttpServletRequest request, HttpServletResponse response){
        String oid = request.getParameter("oid");
        List list = orderService.queryOrderByOid(oid);
        request.setAttribute("order",list.get(0));
        System.out.println(list.get(0));
        Map<OrderItem, CartItem> map = (Map<OrderItem, CartItem>) list.get(1);
        Map<String,CartItem> map1 = new HashMap<>();
        for (OrderItem orderItem : map.keySet()) {
            CartItem cartItem = map.get(orderItem);
            map1.put(cartItem.getBook().getBid(),cartItem);
        }
        request.setAttribute("cart",map1);
        return "f:/jsps/order/desc.jsp";
    }

    public String receiving(HttpServletRequest request, HttpServletResponse response){
        String oid = request.getParameter("oid");
        try {
            orderService.receiving(oid);
        } catch (ReceiveException e) {
            request.setAttribute("msg",e.getMessage());
            return "f:/jsps/order/msg.jsp";
        }
        request.setAttribute("msg","收货成功");
        return "f:/jsps/order/msg.jsp";
    }

    private Order createOrder(HttpServletRequest request){
        Order order = new Order();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String uid= (String) request.getSession().getAttribute("uid");
        order.setPrice(Double.parseDouble(request.getParameter("price")));
        order.setUid(uid);
        order.setOid(UUID.randomUUID().toString().replaceAll("-",""));
        order.setState(0);// false代表未付款
        order.setOrdertime(sdf.format(d));
        order.setAddress("111");
        return order;
    }

    private Map<String,CartItem> add(Map<String,CartItem> cart){
        Map<String,CartItem> map = new HashMap<>();
        for (Map.Entry<String, CartItem> entry : cart.entrySet()) {
            map.put(entry.getKey(),entry.getValue());
        }
        return map;
    }


}
