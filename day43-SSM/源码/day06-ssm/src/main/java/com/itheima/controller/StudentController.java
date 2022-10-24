package com.itheima.controller;

import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import com.itheima.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //查询所有
    @GetMapping("/student")
    public ResultInfo findAll() {
        List<Student> studentList = studentService.findAll();
        return ResultInfo.success(studentList);
    }

    //新增
    @PostMapping("/student")
    public ResultInfo save(@RequestBody Student student) {
        //1. 调用service保存
        studentService.save(student);

        //2. 返回结果
        return ResultInfo.success(null);
    }


    //根据number查询
    @GetMapping("/student/{number}")
    public ResultInfo findByNumber(@PathVariable("number") String number) {
        //1. 调用service查询
        Student student = studentService.findByNumber(number);

        //2. 返回查询结果
        return ResultInfo.success(student);
    }

    //修改
    @PutMapping("/student")
    public ResultInfo update(@RequestBody Student student){
        //1. 调用service更新
        studentService.update(student);
        //2. 返回结果
        return ResultInfo.success(null);
    }

    //删除
    @DeleteMapping("/student/{number}")
    public ResultInfo delete(@PathVariable("number") String number){
        //1. 调用service删除
        studentService.delete(number);

        //2. 返回结果
        return ResultInfo.success(null);
    }
}
