package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    public void save(Account account) {
        jdbcTemplate.update("insert into account values(null,?,?)",
                account.getName(), account.getBalance());
    }

    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
    }

    public Account findByName(String name) {
        return jdbcTemplate.queryForObject("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class), name);
    }

    public void update(Account account) {
        jdbcTemplate.update("update account set balance = ? where name = ?",
                account.getBalance(), account.getName());
    }

    public void deleteByAid(Integer aid) {
        jdbcTemplate.update("delete from account where aid = ?", aid);
    }
}
