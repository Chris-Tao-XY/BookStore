package com.bjpowernode.service.impl;

import com.bjpowernode.dao.BookDao;
import com.bjpowernode.pojo.Book;
import com.bjpowernode.pojo.Page;
import com.bjpowernode.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Transactional
    @Override
    public Page<Book> pageByPrice(BigDecimal lowest, BigDecimal highest, int pageNO, int pageSize) {
        Page<Book> page=new Page<>();
        if (lowest==null){
            lowest=new BigDecimal(0);
        }if (highest==null){
            highest=new BigDecimal(999999);
        }
        page.setPageTotalCount(bookDao.queryForBookNumberByPrice(lowest,highest));
        page.setItems(bookDao.queryBookByPrice(lowest, highest, pageNO, pageSize));
        page.setPageNO(pageNO);
        page.setPageSize(pageSize);
        int pageTotal = page.getPageTotalCount() % page.getPageSize() == 0 ?
                (int) (page.getPageTotalCount() / page.getPageSize()) :
                (int) (page.getPageTotalCount() / page.getPageSize()) + 1;
        page.setPageTotal(pageTotal);
        return page;
    }
}
