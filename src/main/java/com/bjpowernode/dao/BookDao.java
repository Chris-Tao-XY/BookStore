package com.bjpowernode.dao;


import com.bjpowernode.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface BookDao {
    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    Long queryForBookNumber();

    Long queryForBookNumberByPrice(@Param("lowest") BigDecimal lowest, @Param("highest") BigDecimal highest);

    List<Book> queryForOnePage(@Param("pageNO") int pageNO, @Param("pageSize") int pageSize);

    List<Book> queryBookByPrice(@Param("lowest") BigDecimal lowest, @Param("highest") BigDecimal highest, @Param("pageNO") int pageNO, @Param("pageSize") int pageSize);
}
