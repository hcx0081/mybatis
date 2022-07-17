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
        
        /*如果在核心配置文件中开启延迟加载则会按需执行嵌套查询*/
        List<Order> orderList = orderMapper.findOrdersByUserId(5);
        for (Order order : orderList) {
            System.out.println(order.getId());//只需要获得订单的id而不需要获得用户的信息
        }
        
        //orderList.forEach(System.out::println);
    }
}
