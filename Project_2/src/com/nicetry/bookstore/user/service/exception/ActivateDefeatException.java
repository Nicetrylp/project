package com.nicetry.bookstore.user.service.exception;

public class ActivateDefeatException extends Exception {
    @Override
    public String getMessage() {
        return "激活失败";
    }
}
