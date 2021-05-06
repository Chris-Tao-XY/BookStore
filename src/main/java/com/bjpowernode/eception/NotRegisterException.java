package com.bjpowernode.eception;

public class NotRegisterException extends RuntimeException{
    public NotRegisterException() {
        super();
    }

    public NotRegisterException(String message) {
        super(message);
    }
}
