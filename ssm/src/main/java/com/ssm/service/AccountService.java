package com.ssm.service;

import com.ssm.pojo.Account;

import java.util.List;

public interface AccountService {
    /**
     * 保存账户数据
     *
     * @param account
     */
    void save(Account account);
    
    /**
     * 查询所有账户数据
     *
     * @return
     */
    List<Account> findAll();
}
