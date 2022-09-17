package com.itheima.p4_quanxian.sub;

import com.itheima.p4_quanxian.Fu04;

public class Demo05QuanXian {
    public static void main(String[] args) {
        //测试不同包的无关类
        Fu04 fu04 = new Fu04();
        System.out.println(fu04.a);
        //错误: 不同包的无关类中只有public可以使用
        //System.out.println(fu04.b);
        //System.out.println(fu04.c);
        //System.out.println(fu04.d);
    }
}
