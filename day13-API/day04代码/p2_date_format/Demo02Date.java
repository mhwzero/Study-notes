package com.itheima.p2_date_format;

import java.util.Date;

/*
    1.java.util.Date类介绍:类 Date 表示特定的瞬间，精确到毫秒。

    2.注意:
        (1)时间原点: 1970年1月1日 0时0分0秒   认为是0毫秒
        (2)时间标准: 采用格林威治时间标准
        (3)北京时间与标准时间相差8小时

    3.构造方法:
        (1)public Date(): 把当前时间毫秒值(运行程序的此时此刻)封装成Date对象
        (2)public Date(long date): 把构造方法参数指定的毫秒值封装成Date对象

    4.常用常用方法:
        (1)public long getTime(): 返回调用方法的Date对象对应的毫秒值
        (2)public void setTime(long time): 把方法参数指定的毫秒值设置给调用方法的Date对象
*/
public class Demo02Date {
    public static void main(String[] args) {
        //创建Date类的对象(1970年1月1日 0时0分0秒)
        Date start = new Date(0L);
        System.out.println(start);
        System.out.println(start.toString());

        //创建Date类的对象(当前时间毫秒值)
        Date now = new Date();
        //toString方法: 内部把毫秒值转换成了日期格式字符串
        System.out.println(now);
        System.out.println(now.toString());

        //要求: 把当前日期向后推两天
        //获取当前毫秒值
        long nowMillis = now.getTime();
        //计算两天的毫秒值
        long twoDaysMillis = 2L * 24 * 60 * 60 * 1000;
        //给当前Date对象设置两天后的毫秒值
        now.setTime(nowMillis + twoDaysMillis);

        System.out.println(now);
    }
}
