package com.itheima.servlet;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
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
        //0. 解决中文乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //1. 接收请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username=" + username + ",password=" + password);

        //2. 调用Mapper查询
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUser(username, password);
        MyBatisUtil.commitAndClose(sqlSession);

        if (user != null) {
            //3. 如果存在,转发到IndexServlet
            req.getRequestDispatcher("/indexServlet").forward(req, resp);
        } else {
            //4. 如果不存在,重定向到login.html
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
    }
}
