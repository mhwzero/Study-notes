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
import java.util.ArrayList;
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
    public void testFindByUser1() {
        User user = new User();
        user.setName("黑马111");
        user.setEmail("1231111@itcast.cn");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.findByUser1(user);
    }

    @Test
    public void testFindByUser2() {
        User user = new User();
        //user.setName("黑马111");
        //user.setEmail("1231111@itcast.cn");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.findByUser2(user);
    }



    @Test
    public void testUpdate() throws IOException {
        User user = new User();
        user.setName("哈哈");
        user.setPassword("111");
        user.setEmail("111");
        user.setBirthday(new Date());
        user.setUid(1);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.update(user);
    }

    @Test
    public void testFindByUids1(){
        //指定数据源---collection
        List<Integer> collection = new ArrayList<Integer>();
        collection.add(3);
        collection.add(5);
        collection.add(7);


        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findByUids1(collection);
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindByUids2(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findByUids2(new Integer[]{3,5,7});
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByUids3(){
        User userParam = new User();
        userParam.setUids(new Integer[]{3,5,7});
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findByUids3(userParam);
        for (User user : userList) {
            System.out.println(user);
        }
    }


}
