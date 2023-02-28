package com.mybatis.mapper;

import com.mybatis.pojo.Order;
import com.mybatis.pojo.OrderExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * {@code @Description:}
 */
class OrderMapperTest {
    @Test
    void testSelectByExample() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        // 查询所有数据
        // List<Order> orderList = orderMapper.selectByExample(null);
        // orderList.forEach(System.out::println);
        
        // 根据条件查询
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUidEqualTo(5);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        orderList.forEach(System.out::println);
    }
    
}