package com.nicetry.bookstore.order.service;

import com.nicetry.bookstore.book.dao.BookDao;
import com.nicetry.bookstore.book.domain.Book;
import com.nicetry.bookstore.cart.domain.CartItem;
import com.nicetry.bookstore.order.dao.Order;
import com.nicetry.bookstore.order.dao.OrderItem;
import com.nicetry.bookstore.order.domain.OrderDao;
import com.nicetry.bookstore.order.service.exception.NotPaidException;
import com.nicetry.bookstore.order.service.exception.ReceiveException;
import com.nicetry.bookstore.order.service.exception.ReceiveOverException;

import java.util.*;

public class OrderService {
    private OrderDao orderDao = new OrderDao();
    private BookDao bookDao = new BookDao();
    public void addOrder(Order order, Map<String, CartItem> cart){
        List<OrderItem> list = new ArrayList<>();

        for (Map.Entry<String, CartItem> entry : cart.entrySet()) {
            OrderItem orderItem = new OrderItem();
            Book book = entry.getValue().getBook();
            orderItem.setBid(book.getBid());
            orderItem.setOid(order.getOid());
            orderItem.setCount(entry.getValue().getNumber());
            orderItem.setSubtotal(entry.getValue().getNumber()*book.getPrice());
            orderItem.setIid(UUID.randomUUID().toString().replaceAll("-",""));
//            System.out.println(orderItem);
            list.add(orderItem);
        }
//        System.out.println(order);
        orderDao.insertOrder(order);
        for (OrderItem orderItem : list) {
//            System.out.println("进来了");
            orderDao.insertOrderItem(orderItem);
        }
//        System.out.println("出来了");
    }

    public Map<Order,Map<OrderItem,Book>> queryOrderByUser(String uid) {
        List<Order> orders = orderDao.queryOrderByUser(uid);
        Map<Order,Map<OrderItem,Book>> map = new HashMap<>();
        for (Order order : orders) {
            String oid = order.getOid();
            Map<OrderItem, Book> map1 = query(oid);
            map.put(order,map1);
        }
        return map;
    }

    public List queryOrderByOid(String oid) {
        List list = new ArrayList();
        Order order = orderDao.queryOrderByOid(oid);
        Map<OrderItem, Book> map = query(oid);
        Map<OrderItem,CartItem> map2 = new HashMap<>();
        for (OrderItem item : map.keySet()) {
            CartItem cartItem = new CartItem(item.getCount(),map.get(item));
            map2.put(item,cartItem);
        }
        list.add(0,order);
        list.add(1,map2);
        orderDao.updateStateByOid(oid,1);
        return list;
    }

    private Map<OrderItem,Book> query(String oid){
        List<OrderItem> orderItems = orderDao.queryOrderItemByOid(oid);
        Map<OrderItem,Book> map = new HashMap<>();
        for (OrderItem orderItem : orderItems) {
            Book book = bookDao.queryByBookId(orderItem.getBid());
            map.put(orderItem,book);
        }
        return map;
    }

    public void receiving(String oid) throws ReceiveException {
        Order order = orderDao.queryOrderByOid(oid);
        if (order.getState() == 0){
            //TODO 你还没付款
            throw new NotPaidException();
        }else if (order.getState() == 2){
            //TODO 已经付款了
            throw new ReceiveOverException();
        }else if (order.getState() == 1){
            orderDao.updateStateByOid(oid,2);
            return;
        }
    }
}
