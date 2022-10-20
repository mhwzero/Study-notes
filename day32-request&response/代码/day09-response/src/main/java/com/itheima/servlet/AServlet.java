package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求到达了AServlet");


//        //响应重定向
//        //设置响应状态码
//        resp.setStatus(302);
//
//        //设置响应头
//
//        //在我们的项目中,如果你的请求地址是以/开头, 那么这个/代表的是当前的tomcat地址
//        //resp.setHeader("Location", "/day09-response/bServlet");
//        resp.setHeader("Location", req.getContextPath() + "/bServlet");
//        //resp.setHeader("Location", "https://www.baidu.com");

        //这个是专门用于响应重定向的方法,相当于同时设置了302状态码和响应头
        resp.sendRedirect(req.getContextPath() + "/bServlet");
    }
}
