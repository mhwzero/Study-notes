package com.itheima.p3_baozhuang;

import java.util.ArrayList;

/*
    包装类的概念
    ArrayList集合存储基本类型数据时,要求<>中必须指定基本类型对应的引用类型(包装类)

        基本类型                引用类型(包装类)
        byte                    Byte
        short                   Short
        int                     Integer
        long                    Long
        float                   Float
        double                  Double
        char                    Character
        boolean                 Boolean

    集合中永远只能存储引用类型:
        只需要在创建集合对象时,<>中指定对应的包装类,其它操作都可以按照基本类型完成

    引用类型(包装类)并不是对基本类型的简单替换,而是包装类中提供了大量的方法完成相关功能
*/
public class Demo03BaoZhuang {
    public static void main(String[] args) {
        //创建ArrayList集合list,存储数据类型整数
        //ArrayList<int> list = new ArrayList<int>();
        ArrayList<Integer> list = new ArrayList<>();

        //add方法添加数据
        list.add(new Integer(100));
        list.add(200);//自动装箱: 帮我们把200创建成Integer对象
        list.add(300);//自动装箱: 帮我们把300创建成Integer对象

        //遍历
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);//自动拆箱: 把Integer内部的int数字自动获取出来
            System.out.println(num);
        }
    }
}
