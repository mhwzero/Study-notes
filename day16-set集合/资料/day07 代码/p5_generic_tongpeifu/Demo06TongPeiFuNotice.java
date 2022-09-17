package com.itheima.p5_generic_tongpeifu;

import com.itheima.p1_collections.Student;

import java.util.ArrayList;
import java.util.List;

/*

    泛型通配符: ?
        用来匹配泛型的,但是不能使用?定义泛型

    注意事项:
        1.泛型是不存在多态的,左侧<>中写的类型必须和右侧<>中的类型保持一致(省略右侧<>中的内容)
        2.使用泛型通配符,定义变量:
            List<?> list 可以接收哪些对象?
                只要是List接口实现类的任意泛型对象(创建对象时,只要在<>中写上一种引用类型就可以)都可以
        3.List<?> list: 理解为它是各种泛型List集合对象的父类
 */
public class Demo06TongPeiFuNotice {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<Object>();
        //错误: 泛型不存在多态,要么省略右侧<>的内容,要么左右保持一致
        //List<Object> list3 = new ArrayList<String>();
        //List<Object> list4 = new ArrayList<Integer>();


        List<?> list;
        list = new ArrayList<>();//右侧<>省略不写内容,就是Object
        list = new ArrayList<String>();//右侧<>省略不写内容,就是Object
        list = new ArrayList<Integer>();
        list = new ArrayList<Student>();
    }
}
