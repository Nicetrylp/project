package com.lanou3g.study;

public class User {
    private String uname;
    private int uid;
    private String loc;
    private int age;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", uid=" + uid +
                ", loc='" + loc + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String uname, int id, String loc, int age) {
        this.uname = uname;
        this.uid = id;
        this.loc = loc;
        this.age = age;
    }

    public User() {

    }
}
