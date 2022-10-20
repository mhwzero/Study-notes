package com.itheima.test;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)//指定运行器  这个运行器可以读取配置文件,创建spring容器
@ContextConfiguration(classes = SpringConfig.class)//指定配置类
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("B09");
        account.setBalance(100000F);
        accountService.save(account);
    }
}
