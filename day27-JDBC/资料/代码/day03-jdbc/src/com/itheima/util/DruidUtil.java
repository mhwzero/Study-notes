package com.itheima.util;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DruidUtil {
    private static DruidDataSource dataSource = null;

    //保证代码只运行一次
    static {
        //读取properties文件
        //细节:1. 主要不要后缀  2. 文件位置在src下
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");

        //创建连接池
        dataSource = new DruidDataSource();
        //设置数据库连接四要素
        dataSource.setDriverClassName(rb.getString("jdbc.driver"));
        dataSource.setUrl(rb.getString("jdbc.url"));
        dataSource.setUsername(rb.getString("jdbc.username"));
        dataSource.setPassword(rb.getString("jdbc.password"));
    }

    public static Connection getConnection() {
        try {
            //从连接池中获取连接
            return dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet resultSet, PreparedStatement pstm, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement pstm, Connection connection) {
        close(null, pstm, connection);
    }
}
