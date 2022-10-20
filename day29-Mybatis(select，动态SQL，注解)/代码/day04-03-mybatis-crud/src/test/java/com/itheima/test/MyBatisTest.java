package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    private SqlSession sqlSession = null;

    @Before//标注的方法会在Test方法之前运行
    public void before() {
        sqlSession = MyBatisUtil.getSqlSession();
    }

    @After//标注的方法会在Test方法之后运行
    public void after() {
        MyBatisUtil.commitAndClose(sqlSession);
    }

    @Test
    public void testSave() throws IOException {
        User user = new User();
        user.setName("黑马");
        user.setPassword("123");
        user.setBirthday(new Date());
        user.setEmail("123@itcast.cn");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //UserMapper.save
        mapper.save(user);
        System.out.println(user.getUid());
    }


    @Test
    public void testUpdate() throws IOException {
        User user = new User();
        user.setName("黑马111");
        user.setPassword("123111");
        user.setBirthday(new Date());
        user.setEmail("1231111@itcast.cn");
        user.setUid(1);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.update(user);
    }


    @Test
    public void testDelete() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.delete(2);
    }


    @Test
    public void testFindAll() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }


    @Test
    public void testFindAll2() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll2();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByUid() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findByUid(1);
        System.out.println(user);
    }

    @Test
    public void testFindByNameAndPassword1() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findByNameAndPassword1("黑马","123");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByNameAndPassword2() {
        User userParam = new User();
        userParam.setName("黑马");
        userParam.setPassword("123");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findByNameAndPassword2(userParam);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByNameLike() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findByNameLike("黑马");
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
