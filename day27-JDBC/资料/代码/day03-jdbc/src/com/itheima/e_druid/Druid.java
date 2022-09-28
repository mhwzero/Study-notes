package com.itheima.e_druid;

import com.itheima.util.DruidUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Druid {

    //保存用户
    @Test
    public void test1() throws SQLException {
        Connection connection = DruidUtil.getConnection();

        PreparedStatement pstm = connection.prepareStatement("insert into user values(null,?,?,?)");
        pstm.setString(1, "小兰");
        pstm.setString(2, "admin");
        pstm.setFloat(3, 100);
        pstm.executeUpdate();

        DruidUtil.close(pstm, connection);
    }

    //查询所有
    @Test
    public void test2() throws SQLException {
        Connection connection = DruidUtil.getConnection();

        PreparedStatement pstm = connection.prepareStatement("select * from user");
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }

        DruidUtil.close(resultSet, pstm, connection);
    }


//    //保存用户
//    @Test
//    public void test1() throws SQLException {
//        //1. 创建连接池
//        DruidDataSource dataSource = new DruidDataSource();
//        //设置数据库连接四要素
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql:///db1");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//
//        //2. 从连接池中获取连接
//        Connection connection = dataSource.getConnection();
//
//        PreparedStatement pstm = connection.prepareStatement("insert into user values(null,?,?,?)");
//        pstm.setString(1, "小兰");
//        pstm.setString(2, "admin");
//        pstm.setFloat(3, 100);
//        pstm.executeUpdate();
//
//
//        pstm.close();
//        connection.close();//归还连接
//    }
//
//    //查询所有
//    @Test
//    public void test2() throws SQLException {
//        //1. 创建连接池
//        DruidDataSource dataSource = new DruidDataSource();
//        //设置数据库连接四要素
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql:///db1");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//
//        //2. 从连接池中获取连接
//        Connection connection = dataSource.getConnection();
//
//        PreparedStatement pstm = connection.prepareStatement("select * from user");
//        ResultSet resultSet = pstm.executeQuery();
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("username"));
//        }
//
//        resultSet.close();
//        pstm.close();
//        connection.close();
//    }
}
