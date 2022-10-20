package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import com.itheima.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> findAll() {
        //1. 获取mapper对象
        SqlSession sqlSession = MyBatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //2. 操作
        List<Student> studentList = mapper.findAll();

        //3. 关闭sqlSession
        MyBatisUtil.close(sqlSession);

        return studentList;
    }

    @Override
    public void save(Student student) {
        //1. 获取mapper对象
        SqlSession sqlSession = MyBatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //2. 操作
        mapper.save(student);

        //3. 关闭sqlSession
        MyBatisUtil.close(sqlSession);
    }

    @Override
    public Student findById(String id) {
        //1. 获取mapper对象
        SqlSession sqlSession = MyBatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //2. 操作
        Student student = mapper.findById(id);

        //3. 关闭sqlSession
        MyBatisUtil.close(sqlSession);

        return student;
    }

    @Override
    public void update(Student student) {
        //1. 获取mapper对象
        SqlSession sqlSession = MyBatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //2. 操作
        mapper.update(student);

        //3. 关闭sqlSession
        MyBatisUtil.close(sqlSession);
    }

    @Override
    public void delete(String id) {
        //1. 获取mapper对象
        SqlSession sqlSession = MyBatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //2. 操作
        mapper.delete(id);

        //3. 关闭sqlSession
        MyBatisUtil.close(sqlSession);
    }

    @Override
    public PageInfo<Student> findByPage(Integer pageNum, Integer pageSize) {
        //1. 获取mapper对象
        SqlSession sqlSession = MyBatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //2-1. 开始分页
        PageHelper.startPage(pageNum,pageSize);

        //2-2. 调用查询所有方法(不包含分页limit)
        List<Student> list = mapper.findAll();

        //2-3 .创建PageInfo对象
        PageInfo<Student> pageInfo = new PageInfo<>(list);

        //3. 关闭sqlSession
        MyBatisUtil.close(sqlSession);

        return pageInfo;
    }


//    @Override
//    public PageInfo<Student> findByPage(Integer pageNum, Integer pageSize) {
//        //1. 获取mapper对象
//        SqlSession sqlSession = MyBatisUtil.openSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//
//        //2-1 调用mapper查询total总记录数
//        Integer total = mapper.findTotal();
//        //2-2 计算pages, 总页数
//        Integer pages = total % pageSize == 0 ? (total / pageSize) : (total / pageSize + 1);
//        //2-3 计算startIndex 开始索引
//        Integer startIndex = (pageNum - 1) * pageSize;
//        //2-4 调用mapper查询list
//        List<Student> list = mapper.findList(startIndex, pageSize);
//        //2-5 创建PageInfo,封装结果
//        PageInfo<Student> pageInfo = new PageInfo<>(total, pages, list, pageNum, pageSize);
//
//
//        //3. 关闭sqlSession
//        MyBatisUtil.close(sqlSession);
//
//        //不要忘了这句
//        return pageInfo;
//    }
}
