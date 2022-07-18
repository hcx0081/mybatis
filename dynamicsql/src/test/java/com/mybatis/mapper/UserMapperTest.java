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
import java.util.HashMap;
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
        user.setUsername("wu");
        user.setPassword("123");
        List<User> userList = userMapper.findByCondition(user);
        userList.forEach(System.out::println);
    }
    
    @Test
    void findByChooseTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        
        User user = new User();
        List<User> userList = userMapper.findByChoose(user);
        userList.forEach(System.out::println);
    }
    
    @Test
    void findByIdsTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<User> userList = userMapper.findByIds(ids);
        userList.forEach(System.out::println);
    }
    
    @Test
    void selectByIdAndUsernameTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        
        User user = userMapper.selectByIdAndUsername(3, "wangwu");
        
        System.out.println(user);
    }
    
    @Test
    void selectByIdAndUsernameByAnnoTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        
        User user = userMapper.selectByIdAndUsernameByAnno(3, "wangwu");
        
        System.out.println(user);
    }
    
    @Test
    void selectByIdAndUsernameByMapTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 3);
        map.put("username", "wangwu");
        User user = userMapper.selectByIdAndUsernameByMap(map);
        
        System.out.println(user);
    }
    
    @Test
    void selectUserByLikeTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        
        List<User> userList = userMapper.selectUserByLike("wangwu");
        
        System.out.println(userList);
    }
    
    @Test
    void insertUserTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    
        //注意此处传入的id
        User user = new User(0, "zhangsanfeng", "123");
        int rows = userMapper.insertUser(user);
    
        System.out.println("插入了"+rows+"条数据");
        //如果insert语句中没有添加 keyProperty="id" useGeneratedKeys="true" 属性，则查询不出，即id为0
        System.out.println("插入的数据的主键为"+user.getId());
        
        sqlSession.commit();
        sqlSession.close();
    }
}