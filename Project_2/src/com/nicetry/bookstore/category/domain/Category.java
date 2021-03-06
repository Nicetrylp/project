package com.nicetry.bookstore.category.domain;

public class Category {
    private String cid;
    private String cname;

    public Category(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Category() {

    }

    @Override
    public String toString() {
        return "CategoryDao{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

}
