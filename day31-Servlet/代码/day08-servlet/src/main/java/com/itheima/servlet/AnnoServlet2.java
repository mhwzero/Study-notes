package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//1. 继承HttpServlet
//2. 重写service方法
//3. 添加@WebServlet注解
//@WebServlet(
//        urlPatterns = "/annoServlet",//访问路径
//        loadOnStartup = 1,//当前servlet的创建时机
//        initParams = { //自定义配置
//                @WebInitParam(name = "encoding", value = "utf-8")
//        }
//)
@WebServlet("/annoServlet")
public class AnnoServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
