package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class MyBatisTest {
    private SqlSession sqlSession = null;

    @Before
    public void before() {
        sqlSession = MyBatisUtil.getSqlSession();
    }

    @After
    public void after() {
        MyBatisUtil.commitAndClose(sqlSession);
    }

    //新增
    @Test
    public void testSave() {
        User user = new User();
        user.setName("传智");
        user.setPassword("123");
        user.setEmail("admin@itcast.cn");
        user.setBirthday(new Date());

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.save(user);
    }

    //查询所有
    @Test
    public void testFindAll() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        for (User user : userMapper.findAll()) {
            System.out.println(user);
        }
    }
    //主键查询
    @Test
    public void testFindByUid() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.findByUid(3));
    }
    //删除
    @Test
    public void testDelete() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.delete(1);
    }


    @Test
    public void testUpdate(){
        User user = new User();
        user.setName("哈哈");
        user.setPassword("111");
        user.setEmail("111");
        user.setBirthday(new Date());
        user.setUid(5);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.update(user);
    }
}





















