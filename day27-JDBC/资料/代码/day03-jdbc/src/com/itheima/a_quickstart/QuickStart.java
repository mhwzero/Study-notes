package com.itheima.a_quickstart;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.*;

//jdbc入门案例
public class QuickStart {
    //需求: 使用java代码从数据库的user表中的查询`username='柯南' 并且 password='admin' `的用户
    @Test
    public void test1() throws SQLException, ClassNotFoundException {
        //1. 注册驱动
        //DriverManager.registerDriver(new Driver());
        Class.forName("com.mysql.jdbc.Driver");

        //2. 创建连接(高速公路)
        //?useUnicode=true&characterEncoding=UTF-8
        String url = "jdbc:mysql://localhost:3306/db1";//数据库的连接地址
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3. 编写sql(货物)
        String sql = "select * from user where username='柯南' and password='admin'";

        //4. 获取传输对象(小货车)
        Statement statement = connection.createStatement();

        //5. 发送sql,接收结果
        ResultSet resultSet = statement.executeQuery(sql);

        //6. 处理结果
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }

        //7. 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
