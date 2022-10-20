package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceTest {

    @Test
    public void testSave() {
        //0. 准备Account对象
        Account account = new Account();
        account.setName("B03");
        account.setBalance(100000F);

        //1. 启动Spring容器
        ApplicationContext act
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 从容器中获取service,调用方法
        AccountService accountService = act.getBean(AccountService.class);
        accountService.save(account);
    }
}
