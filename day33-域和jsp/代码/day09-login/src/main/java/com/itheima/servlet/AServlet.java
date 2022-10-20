package com.itheima.servlet;

import com.itheima.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//向域对象中放入值
@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 向request域对象中放入name
        req.setAttribute("name", "requestName");

        //2. 向session域对象中放入name
        req.getSession().setAttribute("name", "sessionName");

        //4. 向域对象中放入不同类型的数据
        //4-1 对象
        User user = new User();
        user.setUsername("张三");
        user.setBalance(100f);
        req.setAttribute("user22", user);

        //4-2 集合
        ArrayList<String> list = new ArrayList<String>();
        list.add("王五");
        list.add("赵六");
        req.setAttribute("userList", list);

        //请求转发到a.jsp
        req.getRequestDispatcher("/a.jsp").forward(req, resp);
    }
}
