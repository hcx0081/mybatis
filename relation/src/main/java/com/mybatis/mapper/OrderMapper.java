package com.mybatis.mapper;

import com.mybatis.pojo.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> findOrdersByUserId(Integer userId);
}
