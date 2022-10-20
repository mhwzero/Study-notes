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
        String codeFromPage = req.getParameter("code");
        System.out.println("username=" + username + ",password=" + password + ",code=" + codeFromPage);

        //2. 对比code, 前端传入和session保存
        String codeFromSession = (String) req.getSession().getAttribute("code");
        if (!codeFromPage.equals(codeFromSession)) {
            resp.sendRedirect(req.getContextPath() + "/login.html");
            return;//结束程序
        }

        //3. 调用Mapper查询, 校验用户名和密码
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUser(username, password);
        MyBatisUtil.commitAndClose(sqlSession);
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login.html");
            return;//结束程序
        }

        //4. 如果上面的用户名 密码 验证码校验都通过,转发到IndexServlet
        req.setAttribute("username",username);//放入到request域对象
        //req.getRequestDispatcher("/indexServlet").forward(req, resp);
        //req.getRequestDispatcher("/index.html").forward(req, resp);//直接转发到html页面
        req.getRequestDispatcher("/index.jsp").forward(req, resp);//直接转发到html页面
    }
}
