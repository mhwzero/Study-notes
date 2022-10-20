package com.itheima.web.servlet;

import cn.hutool.core.io.IoUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {

    //创建studentService对象
    StudentService studentService = new StudentServiceImpl();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("findAll")) {
            //查询所有功能
            this.findAll(request, response);
        } else if (action.equals("save")) {
            //添加数据功能
            this.save(request, response);
        } else if (action.equals("update")) {
            //修改数据功能
            this.update(request, response);
        } else if (action.equals("delete")) {
            //删除数据功能
            this.delete(request, response);
        } else if (action.equals("findById")) {
            // 根据主键查询
            this.findById(request, response);
        } else if (action.equals("batchDelete")) {
            // 批量删除
            this.batchDelete(request, response);
        } else if (action.equals("findByPage")) {
            // 分页查询
            this.findByPage(request, response);
        } else {
            response.getWriter().write("action写错了");
        }
    }

    //分页查询
    private void findByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 接收参数
        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));

        //2. 调用service查询
        PageInfo<Student> pageInfo = studentService.findByPage(pageNum, pageSize);

        //3. 结果转json返回
        String json = new ObjectMapper().writeValueAsString(pageInfo);
        response.getWriter().write(json);
    }

    // 批量删除
    private void batchDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ids = request.getParameter("ids");
        for (String id : ids.split(",")) {
            studentService.delete(id);
        }

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("ok");
    }


    //删除
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 接收请求参数hm101,hm102
        String id = request.getParameter("id");

        //2. 调用service删除
        studentService.delete(id);

        //3. 返回一个成功标识
        response.getWriter().write("OK");
    }

    //更新
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 接收数据
        //1-1 接收的是ajax提交的post请求体中的数据,必须使用输入流接收
        ServletInputStream inputStream = request.getInputStream();
        //1-2 读取流中数据,读成字符串
        String json = IoUtil.read(inputStream, "utf-8");
        //1-3 将json字符串转换成student对象
        Student student = new ObjectMapper().readValue(json, Student.class);

        //2. 调用service修改
        studentService.update(student);

        //3. 返回一个成功标识
        response.getWriter().write("OK");
    }

    //根据id查询学生
    private void findById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 接收参数
        String id = request.getParameter("id");

        //2. 调用service根据id查询学生信息
        Student student = studentService.findById(id);

        //3. 将结果转换成json返回
        String json = new ObjectMapper().writeValueAsString(student);
        response.getWriter().write(json);
    }

    //保存学生
    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 接收数据
        //1-1 接收的是ajax提交的post请求体中的数据,必须使用输入流接收
        ServletInputStream inputStream = request.getInputStream();
        //1-2 读取流中数据,读成字符串
        String json = IoUtil.read(inputStream, "utf-8");
        //1-3 将json字符串转换成student对象
        Student student = new ObjectMapper().readValue(json, Student.class);

        //2. 调用service保存
        studentService.save(student);

        //3. 返回一个成功标识
        response.getWriter().write("OK");
    }

    //查询所有
    private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 调用service查询
        List<Student> studentList = studentService.findAll();

        //2. 将结果转换成json返回
        String json = new ObjectMapper().writeValueAsString(studentList);
        response.getWriter().write(json);
    }
}
