package com.nicetry.bookstore.user.service.exception;

public class UsernameNotActivateException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名未激活";
    }
}
