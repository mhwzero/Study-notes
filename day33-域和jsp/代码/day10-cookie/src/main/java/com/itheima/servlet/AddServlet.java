package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 接收浏览器
        String product = req.getParameter("product");//小米 手机

        //在保存到cookie之前进行编码
        String productAfterEncode = URLEncoder.encode(product, "utf-8");

        //2. 将要买的产品保存到cookie
        Cookie cookie = new Cookie("product", productAfterEncode);

        //设置cookie的存活时间
        cookie.setMaxAge(300);

        //3. 将cookie返回给浏览器
        resp.addCookie(cookie);

        //4.提示
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("添加购物车成功了");
    }
}
