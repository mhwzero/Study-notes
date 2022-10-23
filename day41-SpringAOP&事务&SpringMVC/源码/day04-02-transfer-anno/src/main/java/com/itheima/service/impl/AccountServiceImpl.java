package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
        isolation = Isolation.DEFAULT,
        propagation = Propagation.REQUIRED,
        readOnly = false,
        timeout = -1
)//事务控制注解, 代表所有方法上都有此注解; 如果方法上和类上都有, 方法上的优先级搞
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    //@Transactional(readOnly = true)//事务控制注解
    public void transfer(String accountName, String targetName, Float amount) {
        //1. 原账户减钱
        accountDao.diff(accountName, amount);

        //中间代码
        int i = 1 / 0;

        //2. 目标账户加钱
        accountDao.add(targetName, amount);
    }

    void findById() {
        //1. 转账代码  TransferEx

        //2. 日志记录代码 LogEx
    }
}
