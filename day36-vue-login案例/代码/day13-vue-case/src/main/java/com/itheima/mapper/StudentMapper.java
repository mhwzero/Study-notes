package com.itheima.mapper;

import com.itheima.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    //查询学生列表
    @Select("select * from student")
    List<Student> findList();

    //保存用户
    @Insert("insert into student values(#{id},#{name},#{birthday},#{address})")
    void add(Student student);

    //根据id查询
    @Select("select * from student where id = #{id}")
    Student findById(String id);

    //更新
    @Update("update student set name = #{name},birthday = #{birthday},address = #{address} where id = #{id}")
    void update(Student student);

    //删除
    @Delete("delete from student where id = #{id}")
    void deleteById(String id);
}
