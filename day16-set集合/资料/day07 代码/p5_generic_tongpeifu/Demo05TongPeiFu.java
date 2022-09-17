package com.itheima.p5_generic_tongpeifu;

import java.util.*;

/*
	泛型通配符: ?
    	用来匹配泛型的,但是不能使用?定义泛型
*/
public class Demo05TongPeiFu {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");

        Set<Integer> set = new HashSet<>();
        set.add(111);
        set.add(222);
        set.add(333);

        //调用方法
        print(list);
        print(set);
        System.out.println("-------------");

        //调用方法
        print2(list);
        print2(set);
    }
    /*
        定义一个方法,完成以上两个集合的遍历
        使用了泛型统配符
        ?: 代表任意一种引用类型,用来匹配泛型的,但是不能用来定义泛型
     */
    public static void print2(Collection<?> coll) {
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    /*
        定义一个方法,完成以上两个集合的遍历
        定义泛型方法
     */
   public static <E> void print(Collection<E> coll) {
       for (E e : coll) {
           System.out.println(e);
       }
   }
}
