package com.itheima.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//直接继承GenericServlet,实现一个service方法
@WebServlet("/myGenericServlet")
public class MyGenericServlet extends GenericServlet {
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("这是MyGenericServlet的输出");
    }
}
