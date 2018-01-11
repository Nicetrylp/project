package com.nicetry.bookstore.user.service.exception;

public class UsernameNotFoundException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名不存在";
    }
}
