package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void diff(String accountName, Float amount) {
        jdbcTemplate.update("update account set balance = balance - ? where name = ?", amount, accountName);
    }

    public void add(String accountName, Float amount) {
        jdbcTemplate.update("update account set balance = balance + ? where name = ?", amount, accountName);
    }
}
