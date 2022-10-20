package com.itheima.service.impl;

import com.itheima.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    public void save() {
        System.out.println("保存成功");
    }

    public String find() {
        System.out.println("查询成功");
        return "haha";
    }
}
