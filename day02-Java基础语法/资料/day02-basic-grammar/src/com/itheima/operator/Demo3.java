package com.itheima.operator;

public class Demo3 {
    public static void main(String[] args) {
        // 目标：掌握自增自减运算符的使用
        int count = 100;
        count++;
        System.out.println(count);  // 101
        // ++ --可以放到变量后面，也可以放到变量前面使用
        ++count;
        System.out.println(count);  // 102

        System.out.println("============");
        int count1 = 10;
        count1--;
        --count1;
        System.out.println(count1); // 8

//        100++;  // ++ --只能操作变量，不能操作字面量

        System.out.println("============");
        // ++ --如果不是单独使用，放在变量前后有明显区别
        // 如果++ --在变量前，是先对变量+1，-1，再运算
        int x = 10;
        int y = ++x;
        System.out.println(x);  // 11
        System.out.println(y);  // 11

        // 如果++ --在变量后，先运算，再对变量+1, -1
        int m = 10;
        int n = m--;
        System.out.println(m);  // 9
        System.out.println(n);  // 10
    }
}
