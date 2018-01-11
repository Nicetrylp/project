package com.nicetry.bookstore.order.dao;

public class Order {
    private String oid; // 订单id
    private String ordertime; // 下单时间
    private double price; // 价格
    private int state; // 状态
    private String uid; // 用户id
    private String address; // 收货地址

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", ordertime='" + ordertime + '\'' +
                ", price='" + price + '\'' +
                ", state='" + state + '\'' +
                ", uid='" + uid + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order() {

    }

    public Order(String oid, String ordertime, double price, int state, String uid, String address) {

        this.oid = oid;
        this.ordertime = ordertime;
        this.price = price;
        this.state = state;
        this.uid = uid;
        this.address = address;
    }
}
