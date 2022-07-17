package com.mybatis.mapper;

import com.mybatis.pojo.User;

import java.util.List;

/**
 * @Description:
 */
public interface UserMapper {
    List<User> findUserByUserId(int orderId);
}
