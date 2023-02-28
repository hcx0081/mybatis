package com.mybatis.mapper;

import com.mybatis.pojo.User;
import com.mybatis.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    long countByExample(UserExample example);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    int deleteByExample(UserExample example);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    int insert(User row);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    int insertSelective(User row);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    List<User> selectByExample(UserExample example);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("row") User row, @Param("example") UserExample example);
}