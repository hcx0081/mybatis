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
 * {@code @Description:}
 */
public class UserMapperTest {
    InputStream resourceAsStream;
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    
    {
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    void findAllTest() {
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }
    
    @Test
    void oneToManyTest() {
        List<User> userAndOrderAll = userMapper.findUserAndOrderAll();
        userAndOrderAll.forEach(System.out::println);
    }
}