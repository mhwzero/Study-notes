package com.itheima.p4_nbfor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    集合定义格式:
        ArrayList<数据类型> 集合名称 = new ArrayList<数据类型>();
        ArrayList<String> list = new ArrayList<>();

    格式:
        for(集合存储元素的类型 变量名称 : 集合) {
            ...
        }

    注意:
        1.变量名称不是用来存储集合的索引值的,而是用来存储集合中的每个元素的
        2.增强for遍历集合底层使用的是迭代器
        3.增强for遍历集合时,请不要对集合元素进行增删改的操作,否则出现问题,自己解决
        4.增强for遍历集合快捷键:
            集合名.for
 */
public class Demo05NBForCollection {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();

        coll.add("AAA");
        coll.add("BBB");
        coll.add("CCC");
        coll.add("DDD");
        //迭代器遍历
        Iterator<String> it = coll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("--------");
        //增强for遍历
        for(String str : coll){
            System.out.println(str);
        }
        System.out.println("--------");
        //增强for遍历快捷键: 集合名.for
        for (String str : coll) {
            System.out.println(str);
        }
    }
}
