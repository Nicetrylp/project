package com.nicetry.bookstore.admin.admin.service.exception;

public class AdminNameErrorException extends LoginException {
    @Override
    public String getMessage() {
        return "你不是管理员";
    }
}
