package com.itheima.p3_generic_method;

import com.itheima.p1_collections.Student;

/*
    泛型: jdk1.5添加的新特性

    非静态/静态泛型方法: 定义的方法上有属于方法自己的泛型 看MyClass03
        定义方法时,该方法中需要处理某种类型的数据,但是什么类型,不确定,所以定义成泛型
        泛型变量一般用大写字母表示:
            T(Type),E(Element),K(Key),V(Value)

    泛型方法的定义格式:
        //<泛型变>: 定义泛型
        //参列表中: 使用泛型
        修饰符 <泛型变量> 返回值类型 方法名称(泛型变量 变量名称) {
            ...
        }
        举例:
        修饰符 <T> 返回值类型 方法名称(T t) {
            ...
        }

    方法上定义的泛型,什么时间确定具体的类型呢?
        调用方法时,根据方法参数的类型,确定方法上定义的泛型的具体类型
 */
public class Demo03GenericMethod {
    public static void main(String[] args) {
        //创建MyClass03类的对象
        MyClass03<String> mc = new MyClass03<>();

        //正确: 调用method方法
        mc.method("Hello Word");
        //错误: method方法使用类上的泛型,已经被确定为String,不能传递其它数据
        //mc.method(100);

        //对象调用非静态泛型方法
        //非静态泛型方法上的泛型根据传递参数的具体类型确定
        mc.show("Java");
        mc.show(100);
        mc.show(new Student("张三",18));

        //类名调用静态泛型方法
        //静态泛型方法上的泛型根据传递参数的具体类型确定
        MyClass03.print("Java");
        MyClass03.print(100);
        MyClass03.print(new Student("张三",18));
    }
}
