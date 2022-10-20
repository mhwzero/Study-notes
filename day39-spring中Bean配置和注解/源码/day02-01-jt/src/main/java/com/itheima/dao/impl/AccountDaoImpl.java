package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements AccountDao {

    //Spring要求我们,对象是直接从容器中获取的,而不是自己创建的
    //容器给当前对象的jdbcTemplate属性赋值,这个过程称为DI
    //我们推荐使用set方法进行依赖注入(1. 类中提供set方 2. 在配置文件中赋值)
    private JdbcTemplate jdbcTemplate;// = new JdbcTemplate();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
