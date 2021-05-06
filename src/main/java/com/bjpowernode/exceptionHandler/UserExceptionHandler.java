package com.bjpowernode.exceptionHandler;

import com.bjpowernode.eception.AgeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler
    public Object doOtherException(Exception exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("status",404);
        map.put("exception",exception);
        return map;
    }
}