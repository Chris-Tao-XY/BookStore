package com.bjpowernode.controller;


import com.bjpowernode.pojo.Book;
import com.bjpowernode.pojo.Page;
import com.bjpowernode.pojo.User;
import com.bjpowernode.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/client")
@RestController
public class ClientController{
    @Resource
    private BookService bookService;
    @RequestMapping("/display")
    public Object display(HttpServletRequest request,
                          @RequestParam(value = "min") String min,
                          @RequestParam(value = "max")String max,
                          @RequestParam(value = "pageNO") Integer pageNO){
        BigDecimal minPrice=new BigDecimal(min);
        BigDecimal maxPrice=new BigDecimal(max);
        Map<String, Object> map = new HashMap<>();
        Page<Book> page = bookService.pageByPrice(minPrice, maxPrice, pageNO, 4);
        map.put("page", page);
        map.put("min",min);
        map.put("max",max);
        return map;
    }
}
