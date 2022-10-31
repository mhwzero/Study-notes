package com.itmhw.service.impl;

import com.itmhw.domain.Student;
import com.itmhw.mapper.StudentMapper;
import com.itmhw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    //查询全部
    @Override
    public List<Student> finAll() {
        List<Student> students = studentMapper.finAll();
        return students;
    }
    //添加信息
    @Override
    public void save(Student student) {
        studentMapper.save(student);
        int a =1/0;
    }

    //查询单个信息
    @Override
    public Student findByNumber(String number) {
        Student student = studentMapper.findByNumber(number);
        return student;
    }

    //修改信息
    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    //删除信息
    @Override
    public void delete(String number) {
        studentMapper.delete(number);
    }
}
