package com.itheima.c_crud;

import org.junit.Test;

import java.sql.*;

public class Crud {

    //增加用户  username:小兰  password:admin  balance:100
    @Test
    public void testSave() throws SQLException, ClassNotFoundException {
        //1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
        //3. 编写sql
        String sql = "insert into user values(null,?,?,?)";
        //4. 创建PreparedStatement,进行赋值
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, "小兰");
        pstm.setString(2, "admin");
        pstm.setFloat(3, 100);
        //5. 运行
        int i = pstm.executeUpdate();
        //6.结果
        if (i>0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
        //7. 释放资源
        pstm.close();
        connection.close();
    }

    //修改用户小兰的账户余额为1000
    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException {
        //1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
        //3. 编写sql
        String sql = "update user set balance = ? where username = ?";
        //4. 创建PreparedStatement,进行赋值
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setFloat(1, 1000);
        pstm.setString(2, "小兰");
        //5. 运行
        int i = pstm.executeUpdate();
        //6.结果
        if (i>0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
        //7. 释放资源
        pstm.close();
        connection.close();
    }


    //删除用户小兰
    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {
        //1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
        //3. 编写sql
        String sql = "delete from user where username = ?";
        //4. 创建PreparedStatement,进行赋值
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, "小兰");
        //5. 运行
        int i = pstm.executeUpdate();
        //6.结果
        if (i>0){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
        //7. 释放资源
        pstm.close();
        connection.close();
    }

    //查询所有
    @Test
    public void testFindAll() throws SQLException, ClassNotFoundException {
        //1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
        //3. 编写sql
        String sql = "select * from user";
        //4. 创建PreparedStatement,进行赋值
        PreparedStatement pstm = connection.prepareStatement(sql);
        //5. 运行
        ResultSet resultSet = pstm.executeQuery();
        //6.结果
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setBalance(resultSet.getFloat("balance"));
            System.out.println(user);
        }
        //7. 释放资源
        pstm.close();
        connection.close();
    }
}
