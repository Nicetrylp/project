package com.nicetry.bookstore.cart.domain;

import com.nicetry.bookstore.book.domain.Book;

public class CartItem {
    private int number;
    private Book book;

    @Override
    public String toString() {
        return "CartItem{" +
                "number=" + number +
                ", book=" + book +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public CartItem() {

    }

    public CartItem(int number, Book book) {

        this.number = number;
        this.book = book;
    }
}
