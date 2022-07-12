package com.mybatis.mapper;

import com.mybatis.pojo.User;
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
public class UserMapperTest {
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
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
    
    @Test
    void findAllTest() throws IOException {
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }
    
    @Test
    void oneToManyTest(){
        List<User> userAndOrderAll = userMapper.findUserAndOrderAll();
        userAndOrderAll.forEach(System.out::println);
    }
}
