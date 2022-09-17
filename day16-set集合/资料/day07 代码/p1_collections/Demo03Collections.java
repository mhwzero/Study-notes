package com.itheima.p1_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    java.util.Collections类: 操作集合的工具类
    特点:
        1.构造方法private修饰
        2.所有成员static修饰

    常用方法:
        public static <T> void sort(List<T> list，Comparator<T> con) ：
            将集合中元素按照方法参数指定规则con进行排序。
            参数:
                List<T> list: 接口,传递实现类ArrayList/LinkedList对象
                java.util.Comparator<T> con:
                    接口,作用是用来指定排序规则的,必须传递该接口的实现类对象
                    (可以单独定义接口实现类,可以直接传递匿名内部类对象)

                抽象方法:
                    public abstract int compare(T o1, T o2):

                        第一个参数 - 第二个参数: 升序排列
                        第二个参数 - 第一个参数: 降序排列

                        注意:
                            T是引用类型,所以不能用o1和o2直接相减,必须获取到属性值进行相减
        思考:
            1.对于int数字,想按照从大到小的顺序排列?
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }

            2.对于字符串,想按照字符串的长度从大到小的顺序排列?
                public int compare(String o1, String o2) {
                    return o2.length() - o1.length();
                }
 */
public class Demo03Collections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //add: 添加元素
        for (int i = 1; i <= 15; i++) {
            list.add(i * 100);
        }
        System.out.println("集合原内容: " + list);
        //shuffle方法: 打乱List集合中元素的顺序
        Collections.shuffle(list);
        System.out.println("集合乱序后内容: " + list);

        //sort方法: 按照指定规则,完成排序
        //sort方法的第二个参数Comparator接口: 传递具体的实现类对象
        Collections.sort(list,new NumDescComparator());

        System.out.println("集合降序排序后内容: " + list);
    }
}

//定义对数字降序排序的规则,实现Comparator接口重写compare方法
class NumDescComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        //return o1 - o2;//第一个参数 - 第二个参数: 升序
        return o2 - o1;//第二个参数 - 第一个参数: 降序
    }
}
