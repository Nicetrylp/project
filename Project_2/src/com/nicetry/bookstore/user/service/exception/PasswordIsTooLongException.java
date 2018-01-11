package com.nicetry.bookstore.user.service.exception;

public class PasswordIsTooLongException extends RegisterException{
    @Override
    public String getMessage() {
        return "密码太长了";
    }
}
