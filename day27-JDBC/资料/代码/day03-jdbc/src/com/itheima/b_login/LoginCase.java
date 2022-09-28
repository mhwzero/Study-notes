package com.itheima.b_login;

import java.sql.*;
import java.util.Scanner;

//登录案例
public class LoginCase {
    //此处代码只能使用main测试,不能使用@Test
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 接收用户名和密码
        System.out.println("欢迎登录红浪漫");
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名:");
        String username = scanner.nextLine();

        System.out.println("请输入密码:");
        String password = scanner.nextLine();

        //2. 根据用户提供的账号和密码查询
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");

        //=======================修改内容开始===============================//
        String sql = "select * from user where username = ? and password = ?";

        //切换成PreparedStatement
        PreparedStatement pstm = connection.prepareStatement(sql);
        //给占位符位置传参
        pstm.setString(1,username);
        pstm.setString(2,password);

        ResultSet resultSet = pstm.executeQuery();//千万注意: 这个位置不再传参

        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        resultSet.close();
        pstm.close();
        connection.close();

        //=======================修改内容结束===============================//
    }


//此处代码只能使用main测试,不能使用@Test
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        //1. 接收用户名和密码
//        System.out.println("欢迎登录红浪漫");
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("请输入用户名:");
//        String username = scanner.nextLine();
//
//        System.out.println("请输入密码:");
//        String password = scanner.nextLine();
//
//        //2. 根据用户提供的账号和密码查询
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
//
//        String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
//        System.out.println(sql);
//
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        if (resultSet.next()) {
//            System.out.println("登录成功");
//        } else {
//            System.out.println("登录失败");
//        }
//
//        resultSet.close();
//        statement.close();
//        connection.close();
//    }
}
