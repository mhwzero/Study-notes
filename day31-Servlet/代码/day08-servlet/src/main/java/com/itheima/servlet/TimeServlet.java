package com.itheima.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

//自定义一个Servlet, 一个类想要被tomcat正确识别，那么这个类就必须直接或间接的实现Servlet接口
public class TimeServlet implements Servlet {

    private ServletConfig servletConfig = null;

    //初始化 此方法会在当前对象创建之后自动调用,而且仅仅会调用一次

    //tomcat会将读取的配置内容封装到ServletConfig对象中,并且将这个对象作为参数,传入init方法
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("当前对象创建完毕了........");
        this.servletConfig = servletConfig;
    }

    //这个方法是我们浏览器每次请求到达服务器之后,就会自动被调用的一个方法
    //ServletRequest: Tomcat会将浏览器发送过来的请求的行头体封装到这个对象中
    //ServletResponse: Tomcat创建出来用于返回给浏览器的响应对象
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //1. 获取到当前时间
        String date = "当前时间:" + new Date().toLocaleString();

        //2. 打印时间
        System.out.println(date);

        //3. 将时间写回浏览器
        //响应头的作用是告诉浏览器,当前返回内容的格式和编码
        servletResponse.setContentType("text/html;charset=" + this.servletConfig.getInitParameter("encoding"));
        servletResponse.getWriter().write(date);
    }

    //销毁 次方法会在当前对象销毁之前自动调用,而且仅仅会调用一次
    public void destroy() {
        System.out.println("当前对象即将销毁了........");

    }

    //返回当前servlet中配置信息
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    //返回当前servlet的介绍
    public String getServletInfo() {
        return "这是一个返回当前服务器时间的servlet";
    }
}

