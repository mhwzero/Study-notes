package com.itheima.p2_iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    集合存储自定义类型(学生Student类型)并遍历
    实现步骤:
        1.创建标准的学生Student类
        2.创建Collection集合对象coll,存储数据的类型是Student
        3.向Collection集合对象coll中添加多个Student对象
        4.获取迭代器Iterator接口的实现类对象it
        5.使用while循环通过迭代器it遍历集合
        5.1 通过迭代器it判断集合中是否具有下一个元素
        5.2 如果有,通过迭代器it获取下一个元素并输出
 */
public class Demo03Iterator {
    public static void main(String[] args) {
        //2.创建Collection集合对象coll,存储数据的类型是Student
        Collection<Student> coll = new ArrayList<>();

        //3.向Collection集合对象coll中添加多个Student对象
        coll.add(new Student("张三", 18));
        coll.add(new Student("李四", 38));
        coll.add(new Student("王五", 28));

        //4.获取迭代器Iterator接口的实现类对象it
        Iterator<Student> it = coll.iterator();

        //5.使用while循环通过迭代器it遍历集合
        //5.1 通过迭代器it判断集合中是否具有下一个元素
        while (it.hasNext()) {
            //5.2 如果有,通过迭代器it获取下一个元素并输出
            Student stu = it.next();
            //System.out.println(stu);
            System.out.println(stu.getName() + "::" + stu.getAge());
            //错误: 调用一次hasNext方法只能对应的调用一次next方法
            //System.out.println(it.next().getName() + "::" + it.next().getAge());
        }

    }
}
