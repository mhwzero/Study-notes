package com.itheima.service;

import com.itheima.domain.Student;

import java.util.List;

public interface StudentService {

    //查询学生列表
    List<Student> findList();

    //保存用户
    void add(Student student);

    //根据id查询
    Student findById(String id);

    //更新
    void update(Student student);

    //根据id删除
    void deleteById(String id);
}
