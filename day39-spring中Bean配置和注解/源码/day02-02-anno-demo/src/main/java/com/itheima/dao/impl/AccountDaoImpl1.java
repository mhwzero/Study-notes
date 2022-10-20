package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//组件, 作用就是使用被标注的类创建一个对象,并将对象放入Spring容器,
//在容器中默认的id是当前类名首字母小写; 也支持使用@Component("自定义id")
//相当于xml中得<bean id="accountDao" class="com.itheima.dao.impl.AccountDaoImpl">
//@Component("accountDao")
//@Scope("singleton") //单例
//@Scope("prototype") //多例


@Repository
public class AccountDaoImpl1 implements AccountDao {
    public void save() {
        System.out.println("保存成功了.....");
    }

    @PostConstruct //此注解标注的方法会在当前对象创建之后自动执行
    public void init() {
        System.out.println("对象创建完毕了.....");
    }

    @PreDestroy //此注解标注的方法会在当前对象销毁之前自动执行
    public void des() {
        System.out.println("对象即将销毁.....");
    }

}
