package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

//xml--->Java类
//bean--->方法
//非bean--->新注解
@ComponentScan("com.itheima") //组件扫描, 相当于xml中得<context:component-scan base-package="com.itheima">
//@Import(DbConfig.class)//导入另外一个配置类
public class SpringConfig {
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
