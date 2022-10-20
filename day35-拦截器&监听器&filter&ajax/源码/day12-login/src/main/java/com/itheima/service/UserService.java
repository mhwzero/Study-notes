package com.itheima.service;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public User findByUsernameAndPassword(String username, String password) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.findByUsernameAndPassword(username, password);

        MyBatisUtil.commitAndClose(sqlSession);
        return user;
    }
}
