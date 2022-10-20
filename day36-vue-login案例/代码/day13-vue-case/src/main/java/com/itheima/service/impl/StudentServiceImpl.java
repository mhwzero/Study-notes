package com.itheima.service.impl;

import com.itheima.domain.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import com.itheima.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> findList() {
        //1. 获取SqlSession
        SqlSession sqlSession = MyBatisUtil.openSession();

        //2. 获取mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //3. 调用mapper方法
        List<Student> studentList = mapper.findList();

        //4. 关闭sqlSession
        MyBatisUtil.close(sqlSession);

        //5. 返回结果
        return studentList;
    }

    @Override
    public void add(Student student) {
        //1. 获取SqlSession
        SqlSession sqlSession = MyBatisUtil.openSession();

        //2. 获取mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //3. 调用mapper方法
        mapper.add(student);

        //4. 关闭sqlSession
        MyBatisUtil.close(sqlSession);
    }

    @Override
    public Student findById(String id) {
        //1. 获取SqlSession
        SqlSession sqlSession = MyBatisUtil.openSession();

        //2. 获取mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //3. 调用mapper方法
        Student student = mapper.findById(id);

        //4. 关闭sqlSession
        MyBatisUtil.close(sqlSession);

        //5. 返回结果
        return student;
    }

    @Override
    public void update(Student student) {
        //1. 获取SqlSession
        SqlSession sqlSession = MyBatisUtil.openSession();

        //2. 获取mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //3. 调用mapper方法
        mapper.update(student);

        //4. 关闭sqlSession
        MyBatisUtil.close(sqlSession);
    }

    @Override
    public void deleteById(String id) {
        //1. 获取SqlSession
        SqlSession sqlSession = MyBatisUtil.openSession();

        //2. 获取mapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //3. 调用mapper方法
        mapper.deleteById(id);

        //4. 关闭sqlSession
        MyBatisUtil.close(sqlSession);
    }
}
