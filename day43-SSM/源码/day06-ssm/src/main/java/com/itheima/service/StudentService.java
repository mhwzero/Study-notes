package com.itheima.service;

import com.itheima.domain.Student;

import java.util.List;

public interface StudentService {

    //查询所有
    List<Student> findAll();

    //保存
    void save(Student student);

    //根据number查询
    Student findByNumber(String number);

    //修改
    void update(Student student);

    //删除
    void delete(String number);

}
