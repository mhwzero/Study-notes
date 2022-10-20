package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Student;


import java.util.List;

public interface StudentService {

    //查询所有
    List<Student> findAll();

    //保存学生
    void save(Student student);

    //根据id查询学生
    Student findById(String id);

    //根据id修改学生
    void update(Student student);

    //删除
    void delete(String id);

    //分页查询
    PageInfo<Student> findByPage(Integer pageNum, Integer pageSize);
}
