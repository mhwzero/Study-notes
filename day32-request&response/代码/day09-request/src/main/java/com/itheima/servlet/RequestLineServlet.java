package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//GET /day09-request/requestLineServlet?name=zs  HTTP/1.1
@WebServlet("/requestLineServlet")
public class RequestLineServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. String getMethod()       获取请求方式
        System.out.println("请求方式:" + req.getMethod());//GET

        //2. String getRequestURL()   获取请求完整路径(URL)
        System.out.println("请求URL:" + req.getRequestURL());// http://localhost:8080/day09-request/requestLineServlet

        //3. String getRequestURI()   获取请求资源部分(URI)
        System.out.println("请求URI:" + req.getRequestURI());// /day09-request/requestLineServlet

        //4. String getContextPath()  获取项目虚拟目录  [记住]
        System.out.println("虚拟路径:" + req.getContextPath());// /day09-request

        //5. String getServletPath()  获取项目资源路径
        System.out.println("资源路径:" + req.getServletPath());// /requestLineServlet
    }
}
