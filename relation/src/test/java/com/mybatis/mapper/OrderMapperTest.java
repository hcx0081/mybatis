package com.mybatis.mapper;

import com.mybatis.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description:
 */
public class OrderMapperTest {
    @Test
    void oneToOne() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
    
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        
        List<Order> orderList = orderMapper.findAll();
        orderList.forEach(System.out::println);
    }
}
