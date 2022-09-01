package com.itheima.typeconversion;

public class Demo2 {
    public static void main(String[] args) {
        // 目标：掌握表达式中的自动类型转换
        // 在表达式中，类型范围小的变量会自动转换成类型范围大的变量对应的类型参与运算
        byte a = 3;
        short b = 5;
        int c = 6;
        long d = 8;
        float f = 10.0f;
        double e = 9;

        int rs1 = a + c;
        long rs2 = c + d;
        float rs3 = d + f;
        double rs4 = a + e;
        double rs5 = b + 3.14;

        int rs6 = a + b;

        // 在表达式中，byte、short、char直接转换成int参与运算
        byte b11 = 10;
        byte b12 = 20;
        int rs7 = b11 + b12;
//        byte rs8 = b11 + b12;

        // 1.如果表达式中存在double类型的数据，结果一定是double类型
        // 2.如果没有double，有float类型的数据，结果一定是float类型
        // 3.如果double和float类型的数据都没有，但是有long类型的数据，结果一定是long类型
        // 4.如果double、float、long类型的数据都没有，结果一定是int类型

    }
}
