package com.bjpowernode.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
    private Integer id;
    private Timestamp createTime;
    private String status;
    private Integer userId;
    private BigDecimal total;


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                ", total=" + total +
                '}';
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
