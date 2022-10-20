package com.itheima.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.domain.Account;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {

    @Test
    public void save() {
        //1. 创建数据源, 设置四要素
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //2. 创建JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //3. 调用方法
        jdbcTemplate.update("insert into account values(null,?,?)", "B02", 1000000);
    }


    @Test
    public void findAll() {
        //1. 创建数据源, 设置四要素
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //2. 创建JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //3. 调用方法
        List<Account> accountList =
                jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    @Test
    public void findByName() {
        //1. 创建数据源, 设置四要素
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //2. 创建JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //3. 调用方法
        Account account = jdbcTemplate.queryForObject("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class), "B01");
        System.out.println(account);
    }

}
