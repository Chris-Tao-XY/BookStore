package com.bjpowernode.eception;

public class AlreadyExistUserException extends RuntimeException {
    public AlreadyExistUserException() {
        super();
    }

    public AlreadyExistUserException(String message) {
        super(message);
    }
}
