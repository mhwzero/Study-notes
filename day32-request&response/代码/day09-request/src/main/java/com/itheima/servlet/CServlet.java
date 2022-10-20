package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cServlet")
public class CServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求到达了CServlet");

        System.out.println("食物是:" + req.getAttribute("food"));
        System.out.println("客人是:" + req.getAttribute("name"));

        resp.getWriter().write("ok");
    }
}
