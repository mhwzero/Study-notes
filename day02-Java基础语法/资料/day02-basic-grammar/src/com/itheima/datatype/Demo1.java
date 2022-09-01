package com.itheima.datatype;

public class Demo1 {
    public static void main(String[] args) {
        // 需求：掌握数据类型的分类
        // 1. byte, 在内存中占一个字节，表示的范围是-128-127
        byte b1 = -128;
        byte b2 = 0;
        byte b3 = 125;
//        byte b4 = 128;

        // 2.short, 短整型, 在内存中占2个字节
        short money = 30000;
//        short money2 = 35000;    // 超出了short能表示的最大范围

        // 3.int, 整型, 在内存中占4个字节
        int idNo = 1234567890;
//        int idNo2 = 12345678900;    // 超出了int能表示的最大范围

        // 4.long, 长整型，在内存中占8个字节
        // 如果随便写一个整数，默认是int类型，如果随便写一个整数，想让它是long类型，必须在后面加上L/l
//        long l3 = 1234567890123;
        long l1 = 1234567890123l;
        long l2 = 1234567890123L;

        // 5.float, 单精度小数，在内存中占4个字节
        // 如果随便写一个小数，默认是double类型，如果随便写一个小数，想让它是float类型，必须在后面加上F/f
//        float f1 = 3.14;
        float f2 = 3.14f;
        float f3 = 3.14F;

        // 6.double，双精度小数，在内存中占8个字节
        double d1 = 3.14;

        // 7.布尔值，只有两个，true和false
        boolean b11 = true;
        boolean b12 = false;

        // 8.字符型，在内存中占2个字节，表示的范围是：0-65535
        char c1 = '找';
        char c2 = '0';

        // 引用数据类型（先了解一下）
        String str1 = "Angelababy";
    }
}
