package com.itheima.d_transfer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//转账
public class Transfer {

    //从1号用户向2号用户转1元钱
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2. 建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
        PreparedStatement pstm1 = null;
        PreparedStatement pstm2 = null;
        try {

            //开启事务
            connection.setAutoCommit(false);

            //3. 编写sql
            String sql1 = "update user set balance = balance - 1 where id = 1";
            String sql2 = "update user set balance = balance + 1 where id = 2";
            //4. 创建传输sql的对象
            pstm1 = connection.prepareStatement(sql1);
            pstm2 = connection.prepareStatement(sql2);
            //5. 发送sql
            pstm1.executeUpdate();
            //模拟异常
            //int i = 1 / 0;
            pstm2.executeUpdate();

            //提交事务
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            //回滚事务
            connection.rollback();
        }finally {
            //6. 释放资源
            pstm1.close();
            pstm2.close();
            connection.close();
        }
    }
}
