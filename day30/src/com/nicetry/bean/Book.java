package com.nicetry.bean;

public class Book {
    private String bookname;
    private String author;
    private String price;
    private String cover;

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Book(String bookname, String author, String price, String civer) {
        this.bookname = bookname;
        this.author = author;
        this.price = price;
        this.cover = civer;
    }

    public Book() {

    }
}
