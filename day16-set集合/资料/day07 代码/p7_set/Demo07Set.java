package com.itheima.p7_set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*
    java.util.Set<T>接口常用实现类
    java.util.HashSet<T>集合
    特点:
        1.底层数据结构:
            哈希表   数组 + 单向链表/红黑树(链表节点>8 并且 数组元素数量>=64,把链表变成红黑树)
        2.特点: 查询速度嗷嗷快,增删速度也不慢
        3.无序: 不保证存入和取出元素的顺序是一致的
        4.无索引: 不可以通过索引的方式获取元素
        5.不可重复  依赖于HashSet存储对象所属类的hashCode和equals方法
        6.线程不安全,不同步,但是效率高

    java.util.LinkedHashSet<T>集合
    特点:
        1.底层数据结构:
            哈希表+链表   数组 + 双向链表/红黑树(链表节点>8 并且 数组元素数量>=64,链表变成红黑树)
        2.特点: 查询速度嗷嗷快,增删速度也不慢
        3.有序: 保证存入和取出元素的顺序是一致的
        4.无索引: 不可以通过索引的方式获取元素
        5.不可重复  依赖于HashSet存储对象所属类的hashCode和equals方法
        6.线程不安全,不同步,但是效率高
*/
public class Demo07Set {
    public static void main(String[] args) {
        //创建HashSet集合对象
        Set<Integer> set = new HashSet<>();

        //add方法添加数据
        set.add(100);
        set.add(100);
        set.add(100000);
        set.add(100000);
        set.add(200);
        set.add(200);
        set.add(20000);
        set.add(20000);
        set.add(300);
        set.add(300);
        set.add(3000);
        set.add(3000);
        System.out.println(set);//证明: 无序,唯一(不重复)
        //set.get(0);//证明: 不可以通过索引的方式获取元素(无索引)

        System.out.println("------------------");
        Set<String> set2 = new LinkedHashSet<>();
        set2.add("zz");
        set2.add("hhh");
        set2.add("bbbb");
        set2.add("aaaaa");
        set2.add("dddddd");
        set2.add("zz");
        set2.add("hhh");
        set2.add("bbbb");
        set2.add("aaaaa");
        set2.add("dddddd");
        System.out.println(set2);//证明: 有序,唯一(不重复)
        //set2.get(0);//证明: 不可以通过索引的方式获取元素(无索引)
    }
}
