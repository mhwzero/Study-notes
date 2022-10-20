package com.itheima.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.annotations.Insert;
import org.omg.PortableInterceptor.Interceptor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


//此servlet可以接收关于user的所有请求, 包含增删改查
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    //将UserService提升为了成员变量
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //0. 处理中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //1. 接收action的值,就可以判断出请求的目的
        String action = req.getParameter("action");

        //2. 调用方法
        if ("list".equals(action)) {//查询
            list(req, resp);
        } else if ("add".equals(action)) {//新增
            add(req, resp);
        } else if ("delete".equals(action)) {//删除
            delete(req, resp);
        } else if ("findById".equals(action)) {//根据id查询
            findById(req, resp);
        } else if ("update".equals(action)) {//更新
            update(req, resp);
        } else if ("findByName".equals(action)) {//根据用户名查询
            findByName(req, resp);
        } else {
            resp.getWriter().write("兄弟,你的action值是不是写错了....");
        }
    }

    //根据用户名查询
    private void findByName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1. 接收请求参数
        String name = req.getParameter("name");

        //2. 调用service查询
        User user = userService.findByName(name);

        //3. 结果转为json返回
        String json = new ObjectMapper().writeValueAsString(user);
        resp.getWriter().write(json);
    }

    //更新
    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1. 接收参数
        Map<String, String[]> map = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2. 调用service更新
        userService.update(user);

        //3. 页面重定向到查询
        resp.sendRedirect(req.getContextPath() + "/userServlet?action=list");
    }

    //根据id查询
    private void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 接收请求参数
        String idStr = req.getParameter("id");
        Integer id = Integer.parseInt(idStr);

        //2. 调用service查询
        User user = userService.findById(id);

        //3. 结果放入request域对象
        req.setAttribute("user", user);

        //4. 页面转发
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }

    //删除
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 接收参数
        String idStr = req.getParameter("id");
        Integer id = Integer.parseInt(idStr);

        //2. 调用service删除
        //细节:调用的时候注意使用的是对象,而不是类; 类的话只能调用静态方法
        userService.delete(id);

        //3. 页面重定向
        resp.sendRedirect(req.getContextPath() + "/userServlet?action=list");
    }

    //查询
    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 调用service查询
        List<User> userList = userService.findAll();

        //2. 将查询结果保存到request域对象
        req.setAttribute("userList", userList);

        //3. 请求转发到list.jsp
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }

    //新增
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1. 接收参数
        Map<String, String[]> map = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2. 调用service保存
        userService.save(user);

        //3. 页面重定向
        resp.sendRedirect(req.getContextPath() + "/userServlet?action=list");//重定向
    }
}
