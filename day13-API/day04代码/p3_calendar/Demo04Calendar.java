package com.itheima.p3_calendar;

import java.util.Calendar;

/*
    Calendar类的常用方法
        public int get(int field) ：返回给定日历字段的值。
            参数:
                int field: 代表的是要获取的是哪个字段
            返回值:
                int: 代表的是获取到的字段对应的值

        public void set(int field, int value) ：将给定的日历字段设置为给定值。
            参数:
                int field: 代表的是要给哪个字段设置值
                int value: 代表的是设置的值是什么

        public abstract void add(int field, int amount) ：
            根据日历的规则，为给定的日历字段添加或减去指定的时间量。
            给指定字段增加指定的值
            参数:
                int field: 代表的是要给哪个字段增加值
                int amount: 代表的是增加的值是多少
                    正数表示增加,负数表示减少

        public Date getTime() ：把调用方法的Calendar对象转换成Date对象并返回
        public void setTime(Date date): 把调用方法传递的参数Date对象设置给调用方法的Calendar对象

        Calendar类当中的常量
        Calendar.YEAR           代表年     1
        Calendar.MONTH          代表月     2
        Calendar.DAY_OF_MONTH   代表日     5
*/
public class Demo04Calendar {
    public static void main(String[] args) {
        //System.out.println(Calendar.YEAR);//Calendar对象中的年份对应的名字: 1
        //System.out.println(Calendar.MONTH);//Calendar对象中的月份对应的名字: 2
        //System.out.println(Calendar.DAY_OF_MONTH);//Calendar对象中的天数对应的名字: 5
        Calendar cal = Calendar.getInstance();
        //调用方法
        printCalendar(cal);

        //通过set方法 把2022年9月2日 修改成 2025年6月10日
        //修改年
        cal.set(Calendar.YEAR, 2025);
        //修改月
        cal.set(Calendar.MONTH, 5);
        //修改日
        cal.set(Calendar.DAY_OF_MONTH, 10);

        //调用方法
        printCalendar(cal);

        //通过add方法 把2025年6月10日 修改成 2022年9月2日
        //修改年
        cal.add(Calendar.YEAR, -3);
        //修改月
        cal.add(Calendar.MONTH,3);
        //修改日
        cal.add(Calendar.DAY_OF_MONTH,-8);

        //调用方法
        printCalendar(cal);

    }

    //定义方法,打印日期信息
    private static void printCalendar(Calendar cal) {
        //获取年
        //int year = cal.get(1);
        int year = cal.get(Calendar.YEAR);
        //获取月
        //int month = cal.get(2);
        int month = cal.get(Calendar.MONTH);
        //获取日
        //int day = cal.get(5);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "年" + (month + 1) + "月" + day + "日");//1-12月对应的数字是0-11
    }
}
