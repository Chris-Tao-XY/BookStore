package com.bjpowernode.controller;


import com.bjpowernode.pojo.Book;
import com.bjpowernode.pojo.Page;
import com.bjpowernode.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/manager")
@RestController
public class ManagerController {
    @Resource
    private BookService bookService;
    @RequestMapping("/display")
    public Object display(@RequestParam(value = "pageNO") Integer pageNO) {
        Map<String, Object> map = new HashMap<>();
        Page<Book> page = bookService.pageByPrice(null, null, pageNO, 4);
        map.put("page", page);
        return map;
    }

    @RequestMapping("/addBook")
    public Object addBook(@RequestBody Book book, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        bookService.addBook(book);
        map.put("success", book.getName() + "添加成功");
        map.put("url", request.getContextPath() + "/staticResource/pages/manager/book_manager.html");
        return map;
    }

    @RequestMapping("/deleteBook")
    public Object deleteBook(@RequestBody Book book) {
        Map<String, Object> map = new HashMap<>();
        bookService.deleteBook(book.getId());
        map.put("success", book.getName() + "删除成功");
        return map;
    }

    @RequestMapping("/updateBook")
    public Object updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        Map<String, Object> map = new HashMap<>();
        map.put("success", book.getName() + "更改成功");
        return map;
    }

    @RequestMapping("/queryBookById")
    public Object queryBook(@RequestParam(value = "bookId")Integer bookId){
        Book book = bookService.queryBookById(bookId);
        Map<String, Object> map = new HashMap<>();
        map.put("book",book);
        return map;
    }

}
