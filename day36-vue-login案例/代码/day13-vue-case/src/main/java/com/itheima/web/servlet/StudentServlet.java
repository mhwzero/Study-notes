package com.itheima.web.servlet;

import cn.hutool.core.io.IoUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {

    StudentService studentService = new StudentServiceImpl();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收action的值,确定调用的方法
        String action = request.getParameter("action");

        if ("findList".equals(action)) {
            findList(request, response);
        } else if ("add".equals(action)) {
            add(request, response);
        } else if ("findById".equals(action)) {
            findById(request, response);
        } else if ("update".equals(action)) {
            update(request, response);
        } else if ("deleteById".equals(action)) {
            deleteById(request, response);
        } else {
            response.getWriter().write("action值有问题");
        }
    }

    //根据id删除
    private void deleteById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 接收请求参数id
        String id = request.getParameter("id");

        //2. 调用service删除
        studentService.deleteById(id);

        //3. 返回结果
        response.getWriter().write("OK");
    }

    //更新
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 接收请求参数
        //1-1 接收输入流
        ServletInputStream inputStream = request.getInputStream();
        //1-2 将输入流转换成字符串
        String json = IoUtil.read(inputStream, "utf-8");
        //1-3 json字符串转换为对象
        Student student = new ObjectMapper().readValue(json, Student.class);

        //2. 调用service更新
        studentService.update(student);

        //3. 返回结果
        response.getWriter().write("OK");
    }

    //根据id查询
    private void findById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 接收请求参数 id
        String id = request.getParameter("id");

        //2. 调用service查询
        Student student = studentService.findById(id);

        //3. 结果转json返回
        String json = new ObjectMapper().writeValueAsString(student);
        response.getWriter().write(json);
    }

    //新增
    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 接收请求(通过ajax使用post的请求体发送参数,后台使用数据流接收)
        //1-1 接收输入流
        ServletInputStream inputStream = request.getInputStream();
        //1-2 将输入流转换成字符串
        String json = IoUtil.read(inputStream, "utf-8");
        //1-3 json字符串转换为对象
        Student student = new ObjectMapper().readValue(json, Student.class);

        //2. 调用service保存学生对象
        studentService.add(student);

        //3. 返回结果
        response.getWriter().write("OK");
    }

    //查询学生列表
    private void findList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 调用service查询
        List<Student> studentList = studentService.findList();

        //2. 将查询结果转json返回
        String json = new ObjectMapper().writeValueAsString(studentList);
        response.getWriter().write(json);
    }
}
