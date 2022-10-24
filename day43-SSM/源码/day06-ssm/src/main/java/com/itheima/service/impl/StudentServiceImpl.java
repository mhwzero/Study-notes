package com.itheima.service.impl;

import com.itheima.domain.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    public void save(Student student) {
        studentMapper.save(student);
        int i = 1 / 0;
    }

    public Student findByNumber(String number) {
        return studentMapper.findByNumber(number);
    }

    public void update(Student student) {
        studentMapper.update(student);
    }

    public void delete(String number) {
        studentMapper.delete(number);
    }
}
