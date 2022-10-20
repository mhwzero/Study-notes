package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {
    //保存
    void save(Account account);

    //查询所有
    List<Account> findAll();

    //根据name查询
    Account findByName(String name);

    //修改(根据name修改balance)
    void update(Account account);

    //删除(根据id删除)
    void deleteByAid(Integer aid);
}
