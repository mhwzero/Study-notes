package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    //@Autowired 自动装配
    //此注解可以标注在属性上, 也可以标注在属性的set方法上; 如果注解写在属性上,对应set方法是可以省略
    //Spring会根据属性的类型(AccountDao)在容器中查找
    //1. 如果找不到,会报错:  expected at least 1
    //2. 正好找到了一个, 自动完成装配
    //3. 找到了多个  expected single matching bean but found 2: accountDaoImpl,accountDaoImpl1

    @Autowired
    @Qualifier("accountDaoImpl1") // 此注解要跟@Autowired配合使用,代表就是当匹配中多个的时候,根据对象的id确定要注入哪一个
    private AccountDao accountDao;



    public void save() {
        accountDao.save();
    }
}
