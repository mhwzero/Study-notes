package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    //查询所有
    @Select("select * from user")
    List<User> findAll();

    //添加
    @Insert("insert into user values(null,#{name},#{sex},#{age},#{address},#{qq},#{email})")
    void save(User user);

    //删除
    @Delete("delete from user where id = #{id}")
    void delete(Integer id);

    //根据id查询
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    //更新
    @Update("update user set name = #{name},sex = #{sex},age = #{age},address = #{address},qq = #{qq},email = #{email} where id = #{id}")
    void update(User user);

    @Select("select * from user where name = #{name}")
    User findByName(String name);
}
