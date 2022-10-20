package com.itheima.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(new Date().toLocaleString()+"项目启动了");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(new Date().toLocaleString()+"项目停止了");
    }
}
