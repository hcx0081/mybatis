package com.ssm.service.impl;

import com.ssm.mapper.AccountMapper;
import com.ssm.pojo.Account;
import com.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    // InputStream resourceAsStream;
    // {
    //    try {
    //        resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    // }
    // SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    //
    // /* Spring容器管理SqlSession，可以从Spring容器中获取执行操作的Mapper实例，所以省略 */
    // SqlSession sqlSession = sqlSessionFactory.openSession();
    // AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
    
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
        
        /* Spring容器进行声明式事务控制，所以省略 */
        // sqlSession.commit();
        // sqlSession.close();
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