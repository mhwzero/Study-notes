package com.itmhw.test;

import com.itmhw.domain.Student;
import com.itmhw.mapper.StudentMapper;
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
    public void test() throws IOException {
        //1.配置文件，将配置文件读成数据流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.获取mapper，执行操作
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.finAll();
        for (Student student : students) {
            System.out.println(student);
        }
        //5.提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        inputStream.close();
    }
}
