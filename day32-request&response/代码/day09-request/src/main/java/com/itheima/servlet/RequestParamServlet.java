package com.itheima.servlet;

import com.itheima.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/requestParamServlet")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集编码为UTF-8, 注意:位置必须在req对象使用之前
        req.setCharacterEncoding("UTF-8");

//        //接收方式1: 根据一个键接收值
//        //String getParameter(String name)           根据参数名获得参数值(单个)
//        String name = req.getParameter("name");
//        String age = req.getParameter("age");
//
//        //String[] getParameterValues(String name)   根据参数名获得参数值(数组)
//        String[] hobbies = req.getParameterValues("hobby");
//        System.out.println("name=" + name + ",age=" + age + ",hobbies=" + Arrays.toString(hobbies));

        //接收方式2: 直接将所有请求中的参数封装到一个Map集合中
        //Map<String, String []>  getParameterMap()  获得所有的参数，封装到Map集合
        Map<String, String[]> map = req.getParameterMap();

        //将上面map中的值放到User对象中
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
