package com.itheima.mapper;

import com.itheima.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

    //查询全部方法
    @Select("SELECT * FROM student")
    List<Student> findAll();

    //添加数据方法
    @Insert("INSERT INTO student VALUES (#{id},#{name},#{birthday},#{address})")
    void save(Student stu);

    //修改数据方法
    @Update("UPDATE student SET name=#{name},birthday=#{birthday},address=#{address} WHERE id=#{id}")
    void update(Student stu);

    //删除数据方法
    @Delete("DELETE FROM student WHERE id=#{id}")
    void delete(String id);

    //根据主键查询
    @Select("SELECT * FROM student WHERE id=#{id}")
    Student findById(String id);

//    //查询总记录数
//    @Select("select count(0) from student")
//    Integer findTotal();
//
//    //查询指定记录
//    @Select("select * from student limit #{startIndex},#{pageSize}")
//    List<Student> findList(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);
}
