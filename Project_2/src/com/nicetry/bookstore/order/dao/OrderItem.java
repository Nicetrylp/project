package com.nicetry.bookstore.order.dao;

public class OrderItem {
    private String iid; // itemId 订单详情ID
    private int count; // 数量
    private double subtotal; // 统计
    private String oid; // 订单号
    private String bid; // 书id

    @Override
    public String toString() {
        return "OrderItem{" +
                "iid='" + iid + '\'' +
                ", count='" + count + '\'' +
                ", subtotal='" + subtotal + '\'' +
                ", oid='" + oid + '\'' +
                ", bid='" + bid + '\'' +
                '}';
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public OrderItem() {

    }

    public OrderItem(String iid, int count, double subtotal, String oid, String bid) {

        this.iid = iid;
        this.count = count;
        this.subtotal = subtotal;
        this.oid = oid;
        this.bid = bid;
    }
}
