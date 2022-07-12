package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description:
 */
class UserMapperTest {
    @Test
    void findByConditionTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        
        User user = new User();
        user.setUsername("");
        List<User> userList = userMapper.findByCondition(user);
        userList.forEach(System.out::println);
    }
    
    @Test
    void findByIdsTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
    
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    
        List<Integer> ids =new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<User> userList = userMapper.findByIds(ids);
        userList.forEach(System.out::println);
    }
}