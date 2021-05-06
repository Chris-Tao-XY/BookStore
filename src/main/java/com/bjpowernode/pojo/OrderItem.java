package com.bjpowernode.pojo;

import java.math.BigDecimal;

public class OrderItem {
    private Integer id;
    private Integer bookId;
    private Integer orderId;
    private BigDecimal price;
    private Integer count;

    public OrderItem(Integer id, Integer bookId, Integer orderId, BigDecimal price, Integer count) {
        this.id = id;
        this.bookId = bookId;
        this.orderId = orderId;
        this.price = price;
        this.count = count;
    }

    public OrderItem() {
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", orderId=" + orderId +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
