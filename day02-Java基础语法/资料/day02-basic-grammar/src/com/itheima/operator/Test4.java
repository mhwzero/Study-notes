package com.itheima.operator;

public class Test4 {
    public static void main(String[] args) {
        // 需求：请计算下列程序的运行结果
        // c    10  11  12 11
        // d    5   4   5
        // rs3  10 + 12 -  4 - 5 + 1 + 12
        int c = 10;
        int d = 5;
        int rs3 = c++ + ++c - --d - ++d + 1 + c--;
        System.out.println(rs3);
        System.out.println(c);
        System.out.println(d);

    }
}
