package com.nicetry.bookstore.user.service.exception;

public class EmailAlreadyException extends RegisterException {
    @Override
    public String getMessage() {
        return "邮箱已被注册";
    }
}
