package com.mybatis.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @TableName order
 */
public class Order {
    private Integer id;
    private Date orderTime;
    private BigDecimal total;
    
    //一个订单属于一个用户
    private User user;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getOrderTime() {
        return orderTime;
    }
    
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
    
    public BigDecimal getTotal() {
        return total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}