package com.itheima.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//向浏览器输出字符
@WebServlet("/characterServlet")
public class CharacterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //0. 告诉浏览器,目前服务器的编码
        //resp.setHeader("content-type","text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");


        //1. 获取字符输出对象
        PrintWriter writer = resp.getWriter();

        //2. 输出字符串
        writer.write("<b>hello  世界</b>");
    }
}
