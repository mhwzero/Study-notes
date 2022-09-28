package com.itheima.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            //读取配置文件,读成数据流
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

            //创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static void commitAndClose(SqlSession sqlSession) {
        if (sqlSession != null) {
            //提交事务(mybatis默认情况下,不会自动提交事务)
            sqlSession.commit();

            //释放资源
            sqlSession.close();
        }
    }
}
