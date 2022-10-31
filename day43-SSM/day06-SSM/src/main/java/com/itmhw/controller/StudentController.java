package com.itmhw.controller;

import com.itmhw.domain.Student;
import com.itmhw.service.StudentService;
import com.itmhw.vo.ResultInfo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //查询全部
    @GetMapping("/student")
    public ResultInfo findAll(){
        List<Student> students = studentService.finAll();
        return ResultInfo.success(students);
    }
    //添加单个信息
    @PostMapping("/student")
    public ResultInfo save(@RequestBody Student student){
        studentService.save(student);
        return ResultInfo.success(null);
    }
    //查询单个信息
    @GetMapping("/student/{number}")
    public ResultInfo findByNumber(@PathVariable("number") String number){
        Student student = studentService.findByNumber(number);
        return ResultInfo.success(student);
    }
    //修改信息
    @PutMapping("/student")
    public ResultInfo update(@RequestBody Student student){
        studentService.update(student);
        return ResultInfo.success(null);
    }
    //删除信息
    @DeleteMapping("/student/{number}")
    public ResultInfo delete(@PathVariable("number")String number){
        studentService.delete(number);
        return ResultInfo.success(null);
    }
}
