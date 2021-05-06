package com.bjpowernode.eception;

public class NotEnoughException extends RuntimeException{
    public NotEnoughException(){
        super();
    }
    public NotEnoughException(String string){
        super(string);
    }
}
