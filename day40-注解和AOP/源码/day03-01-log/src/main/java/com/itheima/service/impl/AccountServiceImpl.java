package com.itheima.service.impl;

import com.itheima.log.Logger;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private Logger logger;

    //这个代码有什么问题?
    //耦合性高
    //复用性低

    //不要修改原有的业务代码, 还要添加上日志功能

    public void save() {
        logger.m1();

        try {
            System.out.println("保存成功");
        }catch (Exception e){
            logger.m3();
        }

        logger.m2();
    }

    public String find() {
        System.out.println("查询成功");
        return "haha";
    }
}
