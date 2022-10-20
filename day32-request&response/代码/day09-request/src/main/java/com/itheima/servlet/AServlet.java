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

        //向request对象中保存数据
        req.setAttribute("name", "weiLi");
        req.setAttribute("food", "炸鸡");

        //req.getRequestDispatcher("/下一步资源路径").forward(req, resp);  //请求转发
        req.getRequestDispatcher("/bServlet").forward(req, resp);

    }
}










