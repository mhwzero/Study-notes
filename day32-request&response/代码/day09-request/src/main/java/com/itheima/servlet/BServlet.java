package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bServlet")
public class BServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求到达了BServlet");

        //System.out.println(req.getParameter("food"));


        //获取域对象中内容
        System.out.println("要做的食物是:"+req.getAttribute("food"));

        //测试remove
        req.removeAttribute("food");

        req.getRequestDispatcher("/cServlet").forward(req, resp);

    }
}








