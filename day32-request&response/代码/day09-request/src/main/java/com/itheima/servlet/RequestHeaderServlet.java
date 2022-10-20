package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestHeaderServlet")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取指定的请求头的值
        String userAgent = req.getHeader("User-Agent");
        System.out.println("userAgent=" + userAgent);

        //2. 判断
        if (userAgent.contains("Chrome")) {
            System.out.println("谷歌浏览器内核");
        } else if (userAgent.contains("Firefox")) {
            System.out.println("火狐浏览器内核");
        } else {
            System.out.println("未知");
        }
    }
}
