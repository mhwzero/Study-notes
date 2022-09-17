package com.itheima.p1_object;

import java.util.Objects;
/*
    java.util.Objects工具类:
        静态方法:
            public static boolean equals(Object a, Object b): 比较对象是否相同
            特点: 避免了空指针异常
 */
public class Demo03Objects {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "hello";
        //System.out.println(s1.equals(s2));//报空指针异常
        System.out.println(Objects.equals(s1,s2));//false
    }
}
