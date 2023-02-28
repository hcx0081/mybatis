package com.mybatis.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * {@code @Description:}
 */
@Data
public class Order {
    private Integer id;
    private Date orderTime;
    private BigDecimal total;
    private Integer uid;
    
    // 一个订单属于一个用户
    private User user;
}