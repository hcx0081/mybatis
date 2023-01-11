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
public class MyBatisTest {
    
    @Test
    public void entryTest() throws IOException {
        // 读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 根据配置文件构建SqlSessionFactory，获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 通过SqlSessionFactory创建sqlSession，获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行SQL
        List<User> users = sqlSession.selectList("com.mybatis.mapper.UserMapper.findAll");
        
        users.forEach(System.out::println);
        
        // 释放资源
        sqlSession.close();
    }
    
    @Test
    public void insertTest() throws IOException {
        // 读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 根据配置文件构建SqlSessionFactory，获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 通过SqlSessionFactory创建sqlSession，获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行SQL
        User user = new User();
        user.setUsername("qianqi");
        user.setPassword("123");
        sqlSession.insert("com.mybatis.mapper.UserMapper.insert", user);
        
        // 需要提交事务，否则执行不了更新操作
        sqlSession.commit();
        
        // 释放资源
        sqlSession.close();
    }
    
    @Test
    public void updateTest() throws IOException {
        // 读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 根据配置文件构建SqlSessionFactory，获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 通过SqlSessionFactory创建sqlSession，获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行SQL
        User user = new User();
        user.setId(8);
        user.setUsername("qianqiqi");
        user.setPassword("12345");
        sqlSession.update("com.mybatis.mapper.UserMapper.update", user);
        
        // 需要提交事务，否则执行不了更新操作
        sqlSession.commit();
        
        // 释放资源
        sqlSession.close();
    }
    
    @Test
    public void deleteTest() throws IOException {
        // 读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 根据配置文件构建SqlSessionFactory，获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 通过SqlSessionFactory创建sqlSession，获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行SQL
        sqlSession.delete("com.mybatis.mapper.UserMapper.delete", 8);
        
        // 需要提交事务，否则执行不了更新操作
        sqlSession.commit();
        
        // 释放资源
        sqlSession.close();
    }
}