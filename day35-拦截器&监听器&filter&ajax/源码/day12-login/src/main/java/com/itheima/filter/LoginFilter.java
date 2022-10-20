package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/index.jsp")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //1. 获取到session对象
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        //2. 判断session对象中是否有username,
        if (username != null && !"".equals(username)) {
            //如果有,代表在登录的有效期之内; 直接放行
            System.out.println("在登录的有效期之内,放行");
            chain.doFilter(req, resp);
        } else {
            //如果没有, 代表在登录不在有效期; 重定向到登录页面
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
    }


    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }
}
