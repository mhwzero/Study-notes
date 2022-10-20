package com.itheima.mapper;

import com.itheima.domain.User;

public interface UserMapper {

    //保存
    void save(User user);

    //修改 根据主键修改其它
    void update(User user);

    //删除
    void delete(Integer uid);
}
