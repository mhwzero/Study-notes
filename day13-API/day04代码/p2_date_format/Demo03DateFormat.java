package com.itheima.p2_date_format;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    格式化: 把Date对象  --> String
    显示格式                                需要设置的日期格式
         2020年09月23日 10点43分20秒123毫秒         yyyy年MM月dd日 HH点mm分ss秒SSS毫秒
         2020-09-23 10:43:20:123                  yyyy-MM-dd HH:mm:ss:SSS
 */
public class Demo03DateFormat {
    public static void main(String[] args) {
        //1.定义String类型的变量pattern,指定日期格式
        String pattern = "yyyy年MM月dd日 HH点mm分ss秒SSS毫秒";
        //2.创建简单日期格式化SimpleDateFormat类的对象sdf,传递日期格式对象pattern
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        //3.创建当前日期时间的Date对象date
        Date date = new Date();

        //4.使用SimpleDateFormat类的对象sdf调用format方法传递Date对象date,获取结果字符串
        String strDate = sdf.format(date);

        //5.输出结果字符串
        System.out.println(strDate);

    }
}
