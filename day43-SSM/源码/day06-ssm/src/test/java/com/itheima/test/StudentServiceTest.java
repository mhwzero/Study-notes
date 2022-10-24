package com.itheima.test;

import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void testFindAll(){
        List<Student> studentList = studentService.findAll();
        if (studentList != null){
            for (Student student : studentList) {
                System.out.println(student);
            }
        }

    }
}
