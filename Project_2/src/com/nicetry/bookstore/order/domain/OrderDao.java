package com.nicetry.bookstore.order.domain;

import com.nicetry.bookstore.order.dao.Order;
import com.nicetry.bookstore.order.dao.OrderItem;
import com.nicetry.bookstore.util.DBCPUtil;
import com.nicetry.bookstore.util.LPQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    Connection conn = DBCPUtil.getConnection();
    public void insertOrder(Order order){
        String sql = "insert into orders values(?,?,?,?,?,?)";
        String time = order.getOrdertime();
        try {
            int i = new LPQueryRunner().update(DBCPUtil.getConnection(),
                    sql,
                    order.getOid(), time, order.getPrice(),
                    order.getState(), order.getUid(), order.getAddress());
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOrderItem(OrderItem orderItem){
        String sql = "insert into orderitem values(?,?,?,?,?)";
        try {
            int i = new LPQueryRunner().update(DBCPUtil.getConnection(),
                    sql,
                    orderItem.getIid(), orderItem.getCount(), orderItem.getSubtotal(),
                    orderItem.getOid(), orderItem.getBid());
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> queryOrderByUser(String uid) {
        String sql = "select * from orders o where uid = ?";
        List<Order> orders = null;
        try {
             orders= new LPQueryRunner().query(DBCPUtil.getConnection(),
                    sql, new BeanListHandler<Order>(Order.class),
                    uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<OrderItem> queryOrderItemByOid(String oid) {
        String sql = "select * from orderitem  where oid = ?";
        List<OrderItem> orders = null;
        try {
            orders= new LPQueryRunner().query(DBCPUtil.getConnection(),
                    sql, new BeanListHandler<OrderItem>(OrderItem.class),
                    oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Order queryOrderByOid(String oid) {
        String sql = "select * from orders where oid =?";
        Order order = null;
        try {
            order = new LPQueryRunner().query(DBCPUtil.getConnection(),
                    sql,
                    new BeanHandler<Order>(Order.class),
                    oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public void updateStateByOid(String oid,int i){
        String sql = "update orders set state = ? where oid = ?";
        try {
            new LPQueryRunner().update(DBCPUtil.getConnection(),
                    sql,
                    i,oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
