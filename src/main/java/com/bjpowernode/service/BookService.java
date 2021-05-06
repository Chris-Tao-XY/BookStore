package com.bjpowernode.service;

import com.bjpowernode.pojo.Book;
import com.bjpowernode.pojo.Page;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBook(Integer id);
    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public Page<Book> pageByPrice(BigDecimal lowest, BigDecimal highest, int pageNO, int pageSize);
}
