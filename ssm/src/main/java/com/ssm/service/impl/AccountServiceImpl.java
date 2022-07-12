package com.ssm.service.impl;

import com.ssm.mapper.AccountMapper;
import com.ssm.pojo.Account;
import com.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    //InputStream resourceAsStream;
    //{
    //    try {
    //        resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}
    //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    //
    ///*将SqlSession交给Spring容器管理，从容器中获得执行操作的Mapper实例即可*/
    //SqlSession sqlSession = sqlSessionFactory.openSession();
    //AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
    
    @Autowired
    private AccountMapper accountMapper;
    
    /**
     * 保存账户数据
     *
     * @param account
     */
    @Override
    public void save(Account account) {
        accountMapper.save(account);
        
        ///*将事务的控制交给Spring容器进行声明式事务控制*/
        //sqlSession.commit();
        //sqlSession.close();
    }
    
    /**
     * 查询所有账户数据
     *
     * @return
     */
    @Override
    public List<Account> findAll() {
        List<Account> accountList = accountMapper.findAll();
        return accountList;
    }
}




