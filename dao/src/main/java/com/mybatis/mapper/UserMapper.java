package com.mybatis.mapper;

import com.mybatis.pojo.User;

import java.util.List;

/**
 * {@code @Description:}
 */
public interface UserMapper {
    List<User> findAll();
}