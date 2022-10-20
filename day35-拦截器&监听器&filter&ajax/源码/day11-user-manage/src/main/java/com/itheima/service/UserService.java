package com.itheima.service;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService {

    //注意: 这个类中千万不要提取SqlSession为成员变量


    public void delete(Integer id) {
        //1. 获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //2. 获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3. 调用mapper的方法
        mapper.delete(id);
        //4. 关闭sqlSession(不要忘记  不要使用sqlSession.close())
        MyBatisUtil.commitAndClose(sqlSession);
    }

    //查询所有
    public List<User> findAll() {
        //1. 获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //2. 获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3. 调用mapper的方法
        List<User> userList = mapper.findAll();
        //4. 关闭sqlSession(不要忘记  不要使用sqlSession.close())
        MyBatisUtil.commitAndClose(sqlSession);
        //5. 返回结果
        return userList;
    }

    //添加
    public void save(User user) {
        //1. 获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //2. 获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3. 调用mapper的方法
        mapper.save(user);//data too long
        //4. 关闭sqlSession(不要忘记  不要使用sqlSession.close())
        MyBatisUtil.commitAndClose(sqlSession);
    }

    //根据id查询
    public User findById(Integer id) {
        //1. 获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //2. 获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3. 调用mapper的方法
        User user = mapper.findById(id);
        //4. 关闭sqlSession(不要忘记  不要使用sqlSession.close())
        MyBatisUtil.commitAndClose(sqlSession);
        //5. 返回结果
        return user;
    }

    //更新
    public void update(User user) {
        //1. 获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //2. 获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3. 调用mapper的方法
        mapper.update(user);
        //4. 关闭sqlSession(不要忘记  不要使用sqlSession.close())
        MyBatisUtil.commitAndClose(sqlSession);
    }

    //根据username查询
    public User findByName(String name) {
        //1. 获取sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //2. 获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3. 调用mapper的方法
        User user = mapper.findByName(name);
        //4. 关闭sqlSession(不要忘记  不要使用sqlSession.close())
        MyBatisUtil.commitAndClose(sqlSession);
        //5. 返回结果
        return user;
    }
}
















