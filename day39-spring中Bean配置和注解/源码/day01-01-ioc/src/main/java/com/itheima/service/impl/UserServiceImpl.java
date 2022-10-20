package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl {

    //获取UserDao的对象,并调用方法
    @Test
    public void test1() {
        //1. 初始化工厂
        ApplicationContext act =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //new FileSystemXmlApplicationContext("D:\\workspace\\cp398\\spring\\day01-01-ioc\\src\\main\\resources\\applicationContext.xml");

        //2. 从工厂获取对象
        //方式1: 根据对象的id从容器中获取对象
        //如果存在相同id的bean标签,会报错:Bean name 'userDao' is already used in this <beans> element
        //容器中没有此id的对象: No bean named 'userDao2' available
        //UserDao userDao = (UserDao) act.getBean("userDao2");

        //方式2: 根据对象的类型从容器中获取对象
        //如果一个类存在多个对象,会产生错误:expected single matching bean but found 2: userDao,userDao2
        //容器中没有此类型的对象No qualifying bean of type 'com.itheima.service.impl.UserServiceImpl' available
        //UserDao userDao = act.getBean(UserDao.class);


        //方式3: 同时根据id和类型获取
        UserDao userDao = act.getBean("userDao", UserDao.class);
        userDao.save();
    }

    //获取UserDao的对象,并调用方法
    @Test
    public void test2() {
        //1. 初始化工厂
        ApplicationContext act =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println(act.getBean("book"));
        System.out.println(act.getBean("book1"));
        System.out.println(act.getBean("book2"));
    }

    //测试对象的作用域
    @Test
    public void test3() {
        //1. 初始化工厂
        ApplicationContext act =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 获取两次对象,观察地址是否一致
        UserDao userDao1 = (UserDao) act.getBean("userDao");
        UserDao userDao2 = (UserDao) act.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);

    }


    //测试对象的生命周期
    @Test
    public void test4() {
        //1. 初始化工厂
        ClassPathXmlApplicationContext act =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 获取两次对象,观察地址是否一致
        UserDao userDao1 = (UserDao) act.getBean("userDao");
        System.out.println(userDao1);

        //3. 显示的关闭容器
        act.close();
    }

    //测试对象属性赋值(DI)
    @Test
    public void test5() {
        //1. 初始化工厂
        ApplicationContext act =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 获取两次对象,观察地址是否一致
        UserDao userDao = (UserDao) act.getBean("userDao");
        System.out.println(userDao);
    }


    //测试多配置文件
    @Test
    public void test6() {
        //1. 初始化工厂
        ApplicationContext act =
                new ClassPathXmlApplicationContext("bean1.xml");

        //2. 获取两次对象,观察地址是否一致
        UserDao userDao1 = (UserDao) act.getBean("userDao1");
        //UserDao userDao2 = (UserDao) act.getBean("userDao2");
        System.out.println(userDao1);
        //System.out.println(userDao2);
    }
}
