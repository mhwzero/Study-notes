package com.itheima.service.impl;

import com.itheima.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    public void save(Object obj) {
        System.out.println("save");
        //int i = 1 / 0;
    }

    public List findAll() {
        System.out.println("findAll");
        return null;
    }

    public Object findByAid(Integer aid) {
        System.out.println("findByAid");
        return "哈哈";
    }
}
