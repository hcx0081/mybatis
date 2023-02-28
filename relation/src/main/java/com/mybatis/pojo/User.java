package com.mybatis.pojo;

import lombok.Data;

import java.util.List;

/**
 * {@code @Description:}
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    
    // 一个用户有多个订单
    private List<Order> orders;
}