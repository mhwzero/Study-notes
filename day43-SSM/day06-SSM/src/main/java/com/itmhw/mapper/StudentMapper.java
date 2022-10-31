package com.itmhw.mapper;

import com.itmhw.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    @Select("select * from student")
    List<Student> finAll();

    @Insert("insert into student values(#{number},#{name},#{birthday},#{address})")
    void save(Student student);

    @Select("select * from student where number=#{number}")
    Student findByNumber(String number);

    @Update("update student set name=#{name},birthday=#{birthday},address=#{address} where number=#{number}")
    void update(Student student);

    @Delete("delete from student where number=#{number}")
    void delete(String number);
}
