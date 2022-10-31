package com.itmhw.test;

import com.itmhw.domain.Student;
import com.itmhw.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;
    @Test
    public void test(){
        List<Student> students = studentService.finAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
