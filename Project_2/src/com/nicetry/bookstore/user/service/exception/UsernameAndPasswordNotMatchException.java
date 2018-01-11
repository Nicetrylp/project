package com.nicetry.bookstore.user.service.exception;

public class UsernameAndPasswordNotMatchException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名与密码不匹配";
    }
}
