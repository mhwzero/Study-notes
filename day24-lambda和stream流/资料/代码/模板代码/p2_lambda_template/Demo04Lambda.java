package com.itheima.p2_lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    Lambda表达式的省略格式
        1.数据类型可以省略: 
        	(Person p) 简化为 (p)
            (Person p1,Person p2) 简化为 (p1,p2)

        2.如果只有一个参数: ()可以省略 
        	(Person p) 简化为 (p) 再简化为 p
            注意: 没有参数,()不能省略

        3.如果{}中只有一句话,那么{}和分号和return,全部可以省略
            注意: 要么全部省略,要么全部保留

        4.->: 永远不能省略


    Collections工具类,实现自定义排序
	public static <T> void sort(List<T> list，Comparator<T> comp):
		将集合list中元素按照指定规则comp排序。
	参数:
		1.List<T> list: 接口,传递实现类对象  ArrayList,LinkedList
		2.Comparator<T> comp: 接口,传递实现类对象/匿名内部类对象
			抽象方法:
				public int compare(T o1,T o2):用来指定排序的规则的
				第一个参数 - 第二个参数: 升序
				第二个参数 - 第一个参数: 降序
				参数T是引用类型,不能直接减

			举例:
				按照Person对象age属性,从小到大排序
                    public int compare(Person o1,Person o2) {
                        return o1.getAge() - o2.getAge();
                    }

				按照Student对象age属性,从大到小排序
                    public int compare(Person o1,Person o2) {
                        return o2.getAge() - o1.getAge();
                    }
    List集合存储多个Person对象,完成对List集合的排序,按照年龄排序
 */
public class Demo04Lambda {
    public static void main(String[] args) {
        //创建List集合对象,并添加数据
        List<Person> list = new ArrayList<>();
        Collections.addAll(list,
                new Person("张三", 18),
                new Person("李四", 38),
                new Person("王五", 28));

        //System.out.println("按照年龄排序前: " + list);

        //1.匿名内部类的方式
        //age从小到大

        //System.out.println("年龄升序排序后: " + list);

        //2.使用lambda表达式的标准格式
        //age从大到小

        //System.out.println("年龄降序排序后: " + list);

        //3.使用lambda表达式的简化格式
        //age从小到大

        //System.out.println("年龄升序排序后: " + list);
    }
}
