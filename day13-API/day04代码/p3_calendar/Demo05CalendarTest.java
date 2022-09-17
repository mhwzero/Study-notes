package com.itheima.p3_calendar;

import java.util.Calendar;
import java.util.Scanner;

/*
    1.需求:Calendar类的练习_获取任意一年的二月有多少天
          如果可以搞到任意年份的3月份的第1天,把天数减1,得到的就是二月份的最后一天

    2.实现步骤:
        (1)创建键盘录入Scanner类的对象
        (2)获取键盘录入的代表年份的int数字,保存到int变量year中
        (3)获取当前日期时间的Calendar对象cal
        (4)Calendar对象cal调用方法把年份设置成year
        (5)Calendar对象cal调用方法把月份设置成3月
        (6)Calendar对象cal调用方法把天数设置成1
        (7)Calendar对象cal调用方法把天数减1,之后就是2月份的最后一天
        (8)Calendar对象cal调用方法获取天数,保存到int变量days中,表示的就是二月份总共有多少天
        (9)打印int变量days的值
*/
public class Demo05CalendarTest {
    public static void main(String[] args) {
        //(1)创建键盘录入Scanner类的对象
        Scanner sc = new Scanner(System.in);
        //(2)获取键盘录入的代表年份的int数字,保存到int变量year中
        System.out.println("请输入一个年份: ");
        int year = sc.nextInt();
        //(3)获取当前日期时间的Calendar对象cal
        Calendar cal = Calendar.getInstance();
        //(4)Calendar对象cal调用方法把年份设置成year
        //cal.set(Calendar.YEAR, year);
        //(5)Calendar对象cal调用方法把月份设置成3月
        //cal.set(Calendar.MONTH, 2);
        //(6)Calendar对象cal调用方法把天数设置成1
        //cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(year, 2, 1);//此方法直接同时设置年月日

        //(7)Calendar对象cal调用方法把天数减1,之后就是2月份的最后一天
        cal.add(Calendar.DAY_OF_MONTH, -1);
        //(8)Calendar对象cal调用方法获取天数,保存到int变量days中,表示的就是二月份总共有多少天
        int days = cal.get(Calendar.DAY_OF_MONTH);

        //(9)打印int变量days的值
        System.out.println(year + "年的2月份总共有" + days + "天");
    }
}
