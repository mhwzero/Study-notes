package com.itheima.p6_generic_limit;

import java.util.ArrayList;
/*
    泛型上限:
        父类: Person
        子类: Worker
        子类: Teacher
        子类: JavaTeacher
    一个父类的子类可以有任意多个, 如何表示出一个父类的任意子类类型
        ?: 代表任意一种引用类型
        ? extends Person: 代表Person类型或者Person类型的任意子类类型
        ? extends E: 代表E类型或者E类型的任意子类类型

    泛型的上限:
        ? extends Person: 表示Person类型或者Person类型的任意子类型
        ? extends E: 表示E类型或者E类型的任意子类型
 */
public class Demo06ShangXian {
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
        //print(list4);//错误: String类不是Person的子类
        //print(list5);//错误: Integer类不是Person的子类
    }

    /*
        定义一个方法,只能完成以上3个集合的遍历
        	ArrayList<Person>/ArrayList<Worker>/ArrayList<Teacher>
        
        不管是Worker类还是Teacher类,都是Person的子类
        ? extends Person: Person类型或者Person类型的任意子类型
     */
    public static void print(ArrayList<? extends Person> list) {
        for (Person p : list) {
            System.out.println(p);
        }
    }
}