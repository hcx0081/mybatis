package com.ssm.controller;

import com.ssm.pojo.Account;
import com.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * {@code @Description:}
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    
    @RequestMapping("/save")
    @ResponseBody
    public String save(Account account) {
        accountService.save(account);
        return "save success";
    }
    
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Account> accountList = accountService.findAll();
        model.addAttribute("accountList", accountList);
        return "accountList";
    }
    
}