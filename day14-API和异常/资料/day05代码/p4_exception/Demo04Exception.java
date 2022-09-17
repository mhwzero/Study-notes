package com.itheima.p4_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
    异常的分类
        |-- 编译时期异常:checked异常(受检测异常)。
            在编译时期,就会检查,如果没有处理异常,则编译失败。(如日期格式化异常)
            直接继承Exception

        |-- 运行时期异常:runtime异常。
            在运行时期,检查异常.
            在编译时期,运行异常编译器不会检测(不报错)。(如数学异常)
            不影响编译,可以正常生成.class文件,但是运行时期可能会出现问题
            直接继承RuntimeException
*/
public class Demo04Exception {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = "2020-09-24";
        /*
            parse方法内部声明抛出ParseException异常,
            ParseException异常直接继承Exception,
            说明是编译时期异常,在编译阶段必须处理(目前用throws处理),
            不处理编译报错
         */
        Date date = sdf.parse(strDate);
        System.out.println(date);

        System.out.println("-----------");
        int[] array = {10, 20, 30};
        /*
            运行时期会报出索引越界异常:ArrayIndexOutOfBoundsException
            ArrayIndexOutOfBoundsException继承RuntimeException,是
            运行时期异常,不会影响编译,会产生.class文件,只不过在运行时期,
            可能会产生这种问题
         */
        int value = array[5];

        System.out.println(value);
    }
}