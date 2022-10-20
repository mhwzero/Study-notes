package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountDaoTest {

    @Test
    public void testSave() {
        //1. 读取配置文件,创建ioc容器
        ApplicationContext act =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 从容器中获取对象
        AccountDao accountDao1 = act.getBean(AccountDao.class);
        AccountDao accountDao2 = act.getBean(AccountDao.class);

        System.out.println(accountDao1);
        System.out.println(accountDao2);

        //3. 调用对象的方法
        //accountDao.save();
    }
}
