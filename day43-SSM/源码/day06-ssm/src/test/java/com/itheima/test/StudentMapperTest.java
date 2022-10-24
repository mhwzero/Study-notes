package com.itheima.test;

import com.itheima.domain.Student;
import com.itheima.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentMapperTest {
    @Test
    public void testFindAll() throws IOException {
        //1. 读取配置文件,将配置文件读成数据流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        //2. 获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //3. 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4. 获取Mapper,执行操作
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }

        //5. 提交事务
        sqlSession.commit();

        //6. 释放资源
        sqlSession.close();
    }
}
