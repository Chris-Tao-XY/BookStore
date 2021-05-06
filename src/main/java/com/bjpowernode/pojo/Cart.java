package com.bjpowernode.pojo;

import java.math.BigDecimal;

public class Cart {
    private Integer id;
    private Integer userId;
    private Integer count;
    private Integer bookId;
    private BigDecimal price;
    private String bookname;
    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", count=" + count +
                ", bookId=" + bookId +
                ", price=" + price +
                ", bookname='" + bookname + '\'' +
                '}';
    }

    public BigDecimal getTotal(){
        return price.multiply(new BigDecimal(count));
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
