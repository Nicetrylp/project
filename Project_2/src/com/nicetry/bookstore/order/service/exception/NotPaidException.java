package com.nicetry.bookstore.order.service.exception;

public class NotPaidException extends ReceiveException {
    @Override
    public String getMessage() {
        return "你还没付钱呢";
    }
}
