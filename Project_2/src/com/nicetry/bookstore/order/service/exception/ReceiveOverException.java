package com.nicetry.bookstore.order.service.exception;

public class ReceiveOverException extends ReceiveException {
    @Override
    public String getMessage() {
        return "你已经收货了呢";
    }
}
