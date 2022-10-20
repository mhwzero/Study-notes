package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

//自定义的Filter类必须实现javax.servlet.Filter
//@WebFilter({"/target.jsp", "*.html"}) //使用注解声明拦截路径,支持数组的写法
public class LogFilter implements Filter {

    //初始化: 这个方法会在当前Filter创建之后,立即执行(tomcat启动的时候,执行1次)
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter创建完成了");
    }

    //此方法用于拦截处理操作(请求只要是满足了拦截路径,都会进入到此方法)
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //打印进入资源之前的时间
        System.out.println("进入资源之前的时间:" + new Date().toLocaleString());

        //放行请求
        filterChain.doFilter(servletRequest, servletResponse);

        //打印离开资源之后的时间
        System.out.println("离开资源之后的时间:" + new Date().toLocaleString());
    }


    //销毁: 这个方法会在当前Filter销毁之前,立即执行(tomcat停止的时候执行1次)
    public void destroy() {
        System.out.println("LogFilter即将销毁了");

    }
}
