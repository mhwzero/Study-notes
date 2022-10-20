package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration//配置, 声明当前这个类是配置类; Spring容器在启动的时候会自动扫描所有配置类中得注解
@PropertySource("jdbc.properties")//读取类路径下的properties文件
public class DbConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //--->new?
    //--->相当于创建对象的三种的方式中的哪一种?  实例化工厂

    //@Bean 只能标注方法上,作用就是将方法的返回值对象放入容器
    //在容器中默认的id是当前方法名称; 也可以使用注解的value属性指定id
    //如果当前方法是需要参数的,Spring会自动在自己的容器中查找需要参数的值
    @Bean("dataSource")
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}
