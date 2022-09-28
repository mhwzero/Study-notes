package com.itheima.p2_lambda;

import java.util.Arrays;
import java.util.Comparator;

/*
    Lambda表达式有参数有返回值

    Arrays工具类,实现自定义排序
	静态方法
        public static <T> void sort(T[] arr，Comparator<T> comp):
        	将数组arr中元素按照指定规则comp排序。
        参数:
            1.T[] arr: 对象数组
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

	    定义Person数组,对数组元素按照年龄升序排列
 */
public class Demo03Lambda {
    public static void main(String[] args) {
        //创建Person数组
        Person[] ps =
                {new Person("张三", 18), new Person("李四", 38), new Person("王五", 28)};

        //System.out.println("排序前: " + Arrays.toString(ps));

        //1.匿名内部类的方式
        //age从小到大

        //System.out.println("年龄从小到大排序后: " + Arrays.toString(ps));

        //2.使用lambda表达式的方式
        //age从大到小

        //System.out.println("年龄从大到小排序后: " + Arrays.toString(ps));
    }
}
