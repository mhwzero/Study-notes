package com.itheima.p1_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    Collections排序自定义规则按照学生年龄排序
 */
public class Demo05Collections {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("zs",18));
        list.add(new Student("ls",38));
        list.add(new Student("ww",28));

        System.out.println("年龄升序排序前: "+list);

        //调用sort方法,按照年龄从小到大的顺序
        //第一个参数: List集合对象
        //第二个参数: Comparator接口的实现类对象
        //单独定义Comparator接口的实现类
        Collections.sort(list,new AgeAscComparator());


        System.out.println("年龄升序排序后: "+list);

        //调用sort方法,按照年龄从大到小的顺序
        //第一个参数: List集合对象
        //第二个参数: Comparator接口的匿名内部类对象
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getAge() - o1.getAge();//第二个参数 - 第一个参数: 降序
            }
        });

        System.out.println("年龄降序排序后: "+list);
    }
}
class AgeAscComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();//第一个参数 - 第二个参数: 升序
    }
}