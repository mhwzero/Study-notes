package com.itheima.p6_generic_limit;

import java.util.ArrayList;

/*
    泛型下限:
        子类: JavaTeacher
        父类: Teacher
        父类: Worker
        父类: Person
    一个子类的父类可以有任意多个, 如何表示出一个子类的任意父类类型
        ?: 代表任意一种引用类型
        ? super JavaTeacher: 代表JavaTeacher类型或者JavaTeacher类型的任意父类类型
        ? super E: 代表E类型或者E类型的任意父类类型

    泛型的下限:
        ? super JavaTeacher: 表示JavaTeacher类型或者JavaTeacher类型的任意父类型
        ? extends E: 表示E类型或者E类型的任意父类型
 */
public class Demo07XiaXian {
    public static void main(String[] args) {
        ArrayList<Person> list1 = new ArrayList<>();
        list1.add(new Person("zs", 18));
        list1.add(new Person("ls", 28));
        list1.add(new Person("ww", 38));

        ArrayList<Worker> list2 = new ArrayList<>();
        list2.add(new Worker("zs01", 18));
        list2.add(new Worker("ls01", 28));
        list2.add(new Worker("ww01", 38));

        ArrayList<Teacher> list3 = new ArrayList<>();
        list3.add(new Teacher("zs02", 18));
        list3.add(new Teacher("ls02", 28));
        list3.add(new Teacher("ww02", 38));

        ArrayList<String> list4 = new ArrayList<>();
        list4.add("aaa");
        list4.add("bbb");

        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(100);
        list5.add(200);


        //调用方法
        print(list1);
        print(list2);
        print(list3);
        //print(list4);//错误: String类不是Teacher的父类
        //print(list5);//错误: Integer类不是Teacher的父类
    }

    /*
        定义一个方法,只能完成以上3个集合的遍历
        	ArrayList<Person>/ArrayList<Worker>/ArrayList<Teacher>
        
        不管是Person类还是Worker类,都是Teacher的父类
        ? super Teacher: Teacher类型或者Teacher类型的任意父类型
     */
    public static void print(ArrayList<? super Teacher> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}