package com.itheima.test;

import com.itheima.config.SpringConfig;
import com.itheima.log.Logger;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private Logger logger;

    @Test
    public void testSave() {

        //1. accountService其实就是目标对象

        //2. 编写增强逻辑
        InvocationHandler invocationHandler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj = null;

                logger.m1();

                try {
                    //代表的就是目标对象的方法
                    obj = method.invoke(accountService, args);
                } catch (Exception e) {
                    logger.m3();
                }

                logger.m2();

                return obj;
            }
        };

        //3. 创建代理对象
        //3-1 创建一个增强器
        Enhancer enhancer = new Enhancer();

        //3-2 设置从哪个类进行代理
        enhancer.setSuperclass(AccountServiceImpl.class);

        //3-3 设置增强逻辑
        enhancer.setCallback(invocationHandler);

        //3-4  创建代理对象
        AccountServiceImpl proxyInstance = (AccountServiceImpl) enhancer.create();


        //4. 调用代理对象的方法
        proxyInstance.save();
        proxyInstance.find();
    }

}
