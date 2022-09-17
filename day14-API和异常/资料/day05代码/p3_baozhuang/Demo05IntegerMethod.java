package com.itheima.p3_baozhuang;

/*
    java.lang.Integer类: 内部会包装一个int/String数字
    1.思考:
        如何获取int数据的取值范围? 最大值和最小值(通过Integer类中的常量)
            public static final int   MAX_VALUE = 0x7f ff ff ff;
            public static final int   MIN_VALUE = 0x80000000;

    2.思考:
        如何获取int数字对应的二进制/八进制/十六进制数字?
            public static String toBinaryString(int i):
                把方法参数int类型的i转换成二进制,并返回对应的String结果

            public static String toOctalString(int i):
                把方法参数int类型的i转换成八进制,并返回对应的String结果

            public static String toHexString(int i):
                把方法参数int类型的i转换成十六进制,并返回对应的String结果

        0b: 表示二进制
        0x: 表示十六进制
        0:  表示八进制
*/
public class Demo05IntegerMethod {
    public static void main(String[] args) {
        System.out.println("int最大值: " + Integer.MAX_VALUE);
        System.out.println("int最小值: " + Integer.MIN_VALUE);
        int num = 100;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toOctalString(num));
        System.out.println(Integer.toHexString(num));

        //输出三个100
        System.out.println(0b1100100);
        System.out.println(0144);
        System.out.println(0x64);

    }
}
