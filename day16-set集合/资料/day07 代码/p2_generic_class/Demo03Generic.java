package com.itheima.p2_generic_class;

import java.util.ArrayList;

/*
    ------------------此代码不用写------------------
    泛型的好处:
        1.避免强制类型转换的麻烦
        2.将运行时异常,提前到了编译时期,降低了程序员的工作量
        3.一旦指定泛型,数据类型将被统一
        4.实现代码的模板化,把数据类型当做参数传递

    泛型可以定义在哪些地方?
        1.可以定义在类上
        2.可以定义在方法(静态方法/非静态方法)上
        3.可以定义在接口上
*/
public class Demo03Generic {
    public static void main(String[] args) {
        //创建集合,指定存储数据的类型String
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bbb");
        list.add("cccc");

        //只能存储String,不能存储Student
        //2.将运行时异常,提前到了编译时期,降低了程序员的工作量
        //list.add(new Student("zs",18));

        //增强for进行遍历
        for (String str : list) {
            System.out.println(str + "的长度" + str.length());//1.避免强制类型转换的麻烦
        }

        System.out.println("-------------");
        //创建集合,不指定存储数据的类型String
        //全部按照Object类型处理
        ArrayList list2 = new ArrayList();
        list2.add("aa");
        list2.add("bbb");
        list2.add("cccc");
        //可以存
        //但是取出来进行强制类型转换,报出类型转换异常
        //list2.add(new Student("zs",18));

        //增强for进行遍历
        for (Object obj : list2) {
            System.out.println(obj + "的长度" + ((String)obj).length());//必须强制类型转换,存在安全隐患
        }
    }
}