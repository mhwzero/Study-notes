package com.itheima.p2_date_format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    解析: 把String --> Date对象
    显示格式                                需要设置的日期格式
         2020年09月23日 10点43分20秒123毫秒         yyyy年MM月dd日 HH点mm分ss秒SSS毫秒
         2020-09-23 10:43:20:123                  yyyy-MM-dd HH:mm:ss:SSS
 */
public class Demo04DateFormat {
    public static void main(String[] args) throws ParseException {
        //1.定义String类型的变量pattern,指定日期格式
        String pattern = "yyyy年MM月dd日 HH点mm分ss秒SSS毫秒";
        //String pattern = "yyyy-MM-dd HH:mm:ss:SSS";

        //2.创建简单日期格式化SimpleDateFormat类的对象sdf,传递日期格式对象pattern
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        //3.创建String的日期对象strDate(必须和日期格式吻合)
        String strDate = "2022年09月02日 11点53分27秒133毫秒";

        //4.使用SimpleDateFormat类的对象sdf调用parse方法传递String对象strDate,获取Date对象date
        Date date = sdf.parse(strDate);

        //5.输出Date对象date
        System.out.println(date);

    }
}
