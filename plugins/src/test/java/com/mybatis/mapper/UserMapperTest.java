package com.mybatis.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
class UserMapperTest {
    @Test
    void pageHelperTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        
        //设置当前页码和每页显示的条数
        PageHelper.startPage(1, 4);
        
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
        
        //获得与分页相关的数据
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("首页页码：" + pageInfo.getFirstPage());
        System.out.println("末页页码：" + pageInfo.getLastPage());
        System.out.println("上一页页码：" + pageInfo.getPrePage());
        System.out.println("下一页页码：" + pageInfo.getNextPage());
        System.out.println("总页码：" + pageInfo.getPages());
        System.out.println("总记录数：" + pageInfo.getTotal());
    }
}