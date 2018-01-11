package com.nicetry.bookstore.user.service.exception;

public class PasswordIsTooShortException extends RegisterException{
    @Override
    public String getMessage() {
        return "密码太短了";
    }
}
