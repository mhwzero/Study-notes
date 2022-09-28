package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //保存
    void save(User user);

    //修改 根据主键修改其它
    void update(User user);

    //删除
    void delete(Integer uid);

    //查询所有
    List<User> findAll();

    //查询所有
    List<User> findAll2();

    //主键查询
    User findByUid(Integer uid);

    //用户名和密码查询
    List<User> findByNameAndPassword1(
            @Param("username") String name,
            @Param("password") String password);

    List<User> findByNameAndPassword2(User user);

    //根据name模糊查询
    List<User> findByNameLike(String name);
}
