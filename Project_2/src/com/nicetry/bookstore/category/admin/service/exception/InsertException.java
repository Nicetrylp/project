package com.nicetry.bookstore.category.admin.service.exception;

public class InsertException extends Exception {
    @Override
    public String getMessage() {
        return "该分类已存在";
    }
}
