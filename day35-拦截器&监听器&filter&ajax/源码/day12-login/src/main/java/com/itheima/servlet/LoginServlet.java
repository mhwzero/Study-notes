package com.itheima.servlet;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import com.itheima.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 接收请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2. 调用service进行查询
        UserService userService = new UserService();
        User user = userService.findByUsernameAndPassword(username, password);

        //3. 判断user是否为空,证明用户名或者面有问题
        if (user == null) {
            System.out.println("用户名或者密码错误");
            resp.sendRedirect(req.getContextPath() + "/login.html");
            return;
        }

        req.getSession().setAttribute("username", username);//将用户名放入session域对象
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
        //req.setAttribute("username", username);
        //req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
