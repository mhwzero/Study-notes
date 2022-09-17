package com.itheima.p1_collection;

import java.util.ArrayList;
import java.util.Collection;

/*
    java.util.Collection<E>接口:
    常用方法:
        public boolean add(E e) ： 把给定的对象添加到当前集合中 。
        public boolean addAll(Collection con):
			把方法参数集合对象con中的所有元素添加到调用方法的集合对象中

        public void clear() :清空集合中所有的元素。
        public boolean remove(E e) : 把给定的对象在当前集合中删除。
            有相同元素,只能删除一个

        public boolean contains(Object obj) : 判断当前集合中是否包含给定的对象。
        public boolean isEmpty() : 判断当前集合是否为空。
        public int size() : 返回集合中元素的个数。
        public Object[] toArray() : 把集合中的元素，存储到数组中。
 */
public class Demo01CollectionMethod {
    public static void main(String[] args) {
        //多态创建Collection集合对象coll,存储数据类型String
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll);//[]
        //add方法: 添加元素
        coll.add("AAA");
        coll.add("BBB");
        System.out.println(coll);//[AAA, BBB]

        Collection<String> coll2 = new ArrayList<>();
        coll2.add("CCC");
        coll2.add("DDD");

        //addAll方法: 把coll2中的所有元素添加到coll中
        coll.addAll(coll2);
        System.out.println("coll = " + coll);//[AAA, BBB, CCC, DDD]
        System.out.println("coll2 = " + coll2);//[CCC, DDD]

        System.out.println("集合元素个数: " + coll.size());//4
        System.out.println("集合是否为空: " + coll.isEmpty());//false

        System.out.println("集合中是否包含BBB? " + coll.contains("BBB"));//true
        System.out.println("集合中是否包含DDD? " + coll.contains("DDD"));//true

        System.out.println("集合中删除BBB元素是否成功? " + coll.remove("BBB"));//true
        System.out.println("集合中删除DDD元素是否成功? " + coll.remove("DDD"));//true
        System.out.println("集合删除BBB和DDD元素后内容: " + coll);//[AAA, CCC]

        System.out.println("集合中是否包含BBB? " + coll.contains("BBB"));//false
        System.out.println("集合中是否包含DDD? " + coll.contains("DDD"));//false

        System.out.println("集合中删除BBB元素是否成功? " + coll.remove("BBB"));//false
        System.out.println("集合中删除DDD元素是否成功? " + coll.remove("DDD"));//false
        System.out.println("--------------");
        //并不是所有的集合都有索引
        //所以: 使用for + get(索引)的方式遍历集合,就不通用了
        for (int i = 0; i < coll.size(); i++) {
            //coll.get(i);
        }

        //toArray方法: 把Collection集合对象转换成Object数组
        //问题: 元素类型被提升为Object,如果使用元素特有方法,必须进行强制类型转换
        Object[] array = coll.toArray();
        //遍历数组
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + "的长度: " + ((String) array[i]).length());
        }
        System.out.println("--------------");

        coll.clear();
        System.out.println("清空集合元素后内容: " + coll);//[]
        System.out.println("集合元素个数: " + coll.size());//0
        System.out.println("集合是否为空: " + coll.isEmpty());//true
    }
}
