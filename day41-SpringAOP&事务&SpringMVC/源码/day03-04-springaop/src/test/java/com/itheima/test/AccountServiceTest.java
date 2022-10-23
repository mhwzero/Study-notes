package com.itheima.test;

import com.itheima.config.SpringConfig;
import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {


    @Autowired
    private AccountService accountService;


    //1. 关注是否会有日志输出? 是
    //2. 关注这个accountService对象到底是谁? 代理对象, 在容器中已经没有目标对象
    @Test
    public void test1() {
//        accountService.save(1);
//        System.out.println("+++++++++++++++++");
//
//        accountService.findAll();
//        System.out.println("+++++++++++++++++");
//
        accountService.findByAid(1);
//        System.out.println("+++++++++++++++++");
    }

}


