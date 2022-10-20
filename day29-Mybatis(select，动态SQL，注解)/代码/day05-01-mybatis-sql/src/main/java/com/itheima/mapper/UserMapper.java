package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //if : 根据User中不为空的属性进行查询
    List<User> findByUser1(User user);

    //choose : 根据User中第一个不为空的属性进行查询
    List<User> findByUser2(User user);

    //根据uid进行更新一个user对象中不为空的属性
    void update(User user);

    //根据uids查询
    List<User> findByUids1(List<Integer> uids);

    List<User> findByUids2(Integer[] uids);

    List<User> findByUids3(User user);

    //类路径
}
