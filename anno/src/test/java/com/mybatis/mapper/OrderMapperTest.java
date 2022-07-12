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
    InputStream resourceAsStream;
    
    {
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
    
    @Test
    void oneToOne() throws IOException {
        List<Order> orderAndUserAll = orderMapper.findOrderAndUserAll();
        orderAndUserAll.forEach(System.out::println);
    }
}
