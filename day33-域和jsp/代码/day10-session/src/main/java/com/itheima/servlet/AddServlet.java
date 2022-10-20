package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 接收请求参数
        String product = req.getParameter("product");

        //2. 获取session,将信息写入
        HttpSession session = req.getSession();
        session.setAttribute("product", product);

        //3. 自动完成,会将上面的sessionid写回浏览器的cookie
//        String id = session.getId();
//        Cookie cookie = new Cookie("JESESSIONID", id);
//        resp.addCookie(cookie);
    }
}
