package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    //增加
    @Insert("insert into user values(null,#{name},#{password},#{email},#{birthday})")
    void save(User user);

    //查询所有
    @Results(
            id = "userMap",//映射关系标识
            value = {
                    @Result(column = "uid",property = "uid",id = true),//主键列
                    @Result(column = "username",property = "name"),//非主键列映射
                    @Result(column = "password",property = "password"),
                    @Result(column = "email",property = "email"),
                    @Result(column = "birthday",property = "birthday")
            }
    )
    @Select("select uid,name as username,password,email,birthday from user")
    List<User> findAll();


    //主键查询
    //查询所有
    @ResultMap("userMap") //指定调用哪个映射规则进行解析
    @Select("select uid,name as username,password,email,birthday from user where uid = #{uid}")
    User findByUid(Integer uid);

    //删除
    @Delete("delete from user where uid = #{uid}")
    void delete(Integer uid);


    //Result Maps collection already contains value for com.itheima.mapper.UserMapper.userMap

//    @Update("<script>        update user\n" +
//            "        <set>\n" +
//            "            <if test=\"name != null and name != ''\">\n" +
//            "                name = #{name},\n" +
//            "            </if>\n" +
//            "            <if test=\"password != null and password != ''\">\n" +
//            "                password = #{password},\n" +
//            "            </if>\n" +
//            "            <if test=\"email != null and email != ''\">\n" +
//            "                email = #{email},\n" +
//            "            </if>\n" +
//            "            <if test=\"birthday != null\">\n" +
//            "                birthday = #{birthday},\n" +
//            "            </if>\n" +
//            "        </set>\n" +
//            "        where\n" +
//            "            uid = #{uid}</script>")
    void update(User user);
}
