package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * {@code @Description:}
 */
public interface UserMapper {
    List<User> findAll();
    
    List<User> findByUserAndPassword(@Param("username") String username, String password);
}