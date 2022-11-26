package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description:
 */
public interface UserMapper {
    @Insert("insert into user values (id = #{id}, username = #{username}, password = #{password});")
    void insert(User user);
    
    @Delete("delete from user where id = #{id};")
    void delete(User user);
    
    @Update("update user set username = #{username}, password = #{password} where id = #{id};")
    void update(User user);
    
    @Select("select * from user;")
    List<User> findAll();
    
    @Select("select * from user where id = #{id};")
    User findById(int id);
    
    // order是关键字，所以为了不报错使用mybatis.order
    // 因为两个表中有重名的字段（id），所以使用别名区分
    @Select("select *,order.id as orderid from user join mybatis.order on user.id=uid;")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(
                    property = "orders",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.mybatis.mapper.OrderMapper.findById")
            )
    })
    List<User> findUserAndOrderAll();
}