package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/target.jsp")
public class BFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入了BFilter,在访问资源之前...");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("回到了BFilter,在访问资源之后...");
    }


    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }
}
