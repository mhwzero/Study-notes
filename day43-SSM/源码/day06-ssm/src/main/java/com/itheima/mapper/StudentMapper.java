package com.itheima.mapper;

import com.itheima.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    //查询所有
    @Select("select * from student")
    List<Student> findAll();

    //保存
    @Insert("insert into student values(#{number},#{name},#{birthday},#{address})")
    void save(Student student);

    //根据number查询
    @Select("select * from student where number = #{number}")
    Student findByNumber(String number);

    //根据number修改
    @Update("update student set name = #{name},birthday = #{birthday},address = #{address} where number = #{number}")
    void update(Student student);

    //根据number删除
    @Delete("delete from student  where number = #{number}")
    void delete(String number);
}
