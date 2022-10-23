package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void transfer(String accountName, String targetName, Float amount) {
        //1. 原账户减钱
        accountDao.diff(accountName, amount);

        //中间代码
        int i = 1 / 0;

        //2. 目标账户加钱
        accountDao.add(targetName, amount);
    }

    void findById(){
        //1. 转账代码  TransferEx

        //2. 日志记录代码 LogEx
    }
}
