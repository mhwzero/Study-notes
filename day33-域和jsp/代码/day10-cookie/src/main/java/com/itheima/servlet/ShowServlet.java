package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/showServlet")
public class ShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        //1. 从请求中获取cookie
        Cookie[] cookies = req.getCookies();

        //2. 解析cookie
        if (cookies == null || cookies.length <= 0) {
            resp.getWriter().write("查询不到购物车信息");
        } else {
            for (Cookie cookie : cookies) {
                if ("product".equals(cookie.getName())) {
                    String value = cookie.getValue();

                    //在查询到cookie的内容之后,进行解码操作
                    String valueAfterDecode = URLDecoder.decode(value, "utf-8");

                    System.out.println("购物车中product的值:" + valueAfterDecode);
                    resp.getWriter().write("查询到产品:" + valueAfterDecode);
                    return;//结束程序
                }
            }
            resp.getWriter().write("查询不到购物车信息");
        }
    }
}
