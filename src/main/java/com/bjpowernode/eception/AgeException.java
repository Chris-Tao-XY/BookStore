package com.bjpowernode.eception;

public class AgeException extends RuntimeException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
