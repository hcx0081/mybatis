package com.mybatis.mapper;

import com.mybatis.pojo.Order;
import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    //order是关键字，所以为了不报错使用mybatis.order
    //因为两个表中有重名的字段（id），所以使用别名区分
    @Select("select *,user.id userid from mybatis.order join user on uid=user.id;")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderTime", column = "ordertime"),
            @Result(property = "total", column = "total"),
            //@Result(property = "user.id",column = "userid"),
            //@Result(property = "user.username",column = "username"),
            //@Result(property = "user.password",column = "password"),
            @Result(
                    property = "user",
                    column = "uid",
                    javaType = User.class,
                    one = @One(select = "com.mybatis.mapper.UserMapper.findById")
            )
    })
    List<Order> findOrderAndUserAll();
    
    @Select("select * from mybatis.order where uid = #{uid};")
    Order findById(int id);
}
