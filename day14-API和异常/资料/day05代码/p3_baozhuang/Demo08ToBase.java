package com.itheima.p3_baozhuang;
/*
    String解析成对应的基本类型(很常用的)
        包装类中除了Character以外,每个包装类都会提供一个静态方法
            public static xxx parseXxx(String str):
                把方法参数String数据str转换成xxx类型的数据

        Integer类:
            public static int parseInt(String str):
                把方法参数String数据str转换成int类型的数据

        Double类:
            public static double parseDouble(String str):
                把方法参数String数据str转换成double类型的数据

        Boolean类:
            public static boolean parseBoolean(String str):
                把方法参数String数据str转换成boolean类型的数据
*/
public class Demo08ToBase {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("10") + 20);//30
        System.out.println(Double.parseDouble("1.1") + 3.3);//4.4
        System.out.println(!Boolean.parseBoolean("true"));//false
    }
}
