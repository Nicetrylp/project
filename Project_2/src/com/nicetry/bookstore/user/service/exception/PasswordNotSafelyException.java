package com.nicetry.bookstore.user.service.exception;

public class PasswordNotSafelyException extends RegisterException{
    @Override
    public String getMessage() {
        return "密码不安全";
    }
}
