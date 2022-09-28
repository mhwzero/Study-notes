package com.itheima.test;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class MyBatisTest {

    @Test
    public void testSave() throws IOException {
        //0. 准备一个User对象
        User user = new User();
        user.setName("黑马");
        user.setPassword("123");
        user.setBirthday(new Date());
        user.setEmail("123@itcast.cn");

        //1. 读取配置文件,读成数据流
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2. 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //3. 获取SqlSession(用来执行sql语句)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4. 执行sql
        //参数一: 办成品sql的标识
        //参数二: 半成品sql中占位符位置需要的值
        //上面两者加在一起就是一个完整的sql
        sqlSession.insert("UserMapper.save",user);

        //5. 提交事务(mybatis默认情况下,不会自动提交事务)
        sqlSession.commit();

        //6. 释放资源
        sqlSession.close();
    }

}
