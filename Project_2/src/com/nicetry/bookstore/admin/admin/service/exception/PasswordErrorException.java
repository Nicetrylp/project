package com.nicetry.bookstore.admin.admin.service.exception;

public class PasswordErrorException extends LoginException {
    @Override
    public String getMessage() {
        return "密码错误";
    }
}
