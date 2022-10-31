package com.itmhw.service;

import com.itmhw.domain.Student;

import java.util.List;

public interface StudentService {
    /**
     * 查询全部信息
     * @return
     */
    List<Student> finAll();

    /**
     * 增加信息
     * @param student
     */
    void save(Student student);

    /**
     * 查询单个信息
     * @param number
     * @return
     */
    Student findByNumber(String number);

    /**
     * 修改信息
     * @param student
     */
    void update(Student student);

    /**
     * 删除信息
     * @param number
     */
    void delete(String number);
}
