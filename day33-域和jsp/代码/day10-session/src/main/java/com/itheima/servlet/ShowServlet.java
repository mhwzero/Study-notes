package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/showServlet")
public class ShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        //1. 根据请求中cookie中携带的JESESSIONID找到对应的session,并返回(自动完成)

        //2. 获取session
        HttpSession session = req.getSession();

        //3. 从session中获取信息
        String product = (String) session.getAttribute("product");
        System.out.println("获取到的购物车内容为:"+product);

        resp.getWriter().write("查询到产品:" + product);
    }
}
