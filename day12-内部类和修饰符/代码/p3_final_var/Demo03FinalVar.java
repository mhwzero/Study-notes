package com.itheima.p3_final_var;

import java.util.Arrays;

/*
    final修饰变量:
        1.特点: 只能赋值一次,不可以进行第二次赋值,变量的值是不可以发生改变的     常量
        2.修饰局部变量(方法内部定义的变量):
            (1)基本类型: 基本类型变量中存储的具体的数字是不可以被改变的

            (2)引用类型: 存储的对象的地址值,被final修饰后,说明变量存储的对象的地址值是不可以被改变的
                                但是该地址代表的内存空间中的内容是可以改变的

        3.成员变量: 看MyClass03 认为默认值无效,要么显式赋值,要么构造方法中赋值
            (1)定义未赋值:
                所有构造方法中,必须完成对final修饰的变量的赋值
                所有成员方法中,不能修改final修饰的变量的值

            (2)定义并赋值:
                所有构造方法/成员方法中,不能修改final修饰的变量的值
 */
public class Demo03FinalVar {
    public static void main(String[] args) {
        final int num = 10;//定义变量,并第一次赋值
        System.out.println(num);//10
        //num = 20;//错误: 不能进行第二次赋值(不能修改变量中的值)

        final int num2;
        num2 = 100;//正确: 是第一次赋值
        System.out.println(num2);
        //num2 = 1000;//错误: 不能进行第二次赋值(不能修改变量中的值)

        //数组变量属于引用变量,保存数组的内存地址值
        //数组变量被final修饰后,说明该数组变量中保存的内存地址是不可改变的
        //也就是说该数组变量永远不可以再指向其它数组了
        final int[] array = new int[]{10, 20, 30};
        System.out.println("数组原始内容: " + Arrays.toString(array));
        //需求: 把数组元素值扩大10倍
        //错误: 数组变量被final修饰后,说明该数组变量中保存的内存地址是不可改变的
        //array = new int[] {100, 200, 300};
        //正确的: 并没有修改数组变量array中保存的地址值,只是修改了该地址对应的内存空间的元素值
        for (int i = 0; i < array.length; i++) {
            array[i] *= 10;
        }
        System.out.println("数组元素扩大10倍后内容: " + Arrays.toString(array));

        final Student stu = new Student("张三", 18);

        stu.show();

        //过了两年,张三的年龄增加两岁
        //错误: stu变量被final修饰,不可以再指向其它对象
        //stu = new Student("张三", 20);

        //正确: 没有修改stu变量中保存的地址,只是修改该地址对应的内存空间中的对象的成员变量的值
        stu.setAge(stu.getAge() + 2);

        stu.show();
    }
}
