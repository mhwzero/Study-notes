package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //0. 解决中文乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //1. 获取request域对象中username
        String username = (String) req.getAttribute("username");

        //2.输出提示
        PrintWriter writer = resp.getWriter();
        writer.write("<!DOCTYPE html>");
        writer.write("<html lang=\"en\">");
        writer.write("<head>");
        writer.write("<meta charset=\"UTF-8\">");
        writer.write("<title>欢迎</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<span style=\"color: red\">");
        writer.write("<b>"+username+"</b>,欢迎访问xxx系统");
        writer.write("</span>");
        writer.write("</body>");
        writer.write("</html>");
    }
}
