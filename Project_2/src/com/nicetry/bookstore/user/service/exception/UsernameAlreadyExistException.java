package com.nicetry.bookstore.user.service.exception;

public class UsernameAlreadyExistException extends RegisterException{
    @Override
    public String getMessage() {
        return "用户名已存在";
    }
}
