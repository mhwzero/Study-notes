package com.itheima.p2_generic_class;

/*
    泛型: jdk1.5添加的新特性

    泛型类: 定义的类上有属于类自己的泛型 看MyClass02
        定义类时,该类中需要处理某种类型的数据,但是什么类型,不确定,所以定义成泛型
        泛型变量一般用大写字母表示:
            T(Type),E(Element),K(Key),V(Value)

    泛型类的定义格式:
        public class 类名<泛型变量> {
            ...
        }
        比如:
        public class 类名<T> {
            ...
        }

    泛型类上定义的泛型,什么时间确定具体的类型呢?
        创建该类的对象时,<>中写的是什么类型,泛型就代表什么类型
 */
public class Demo04GenericClass {
    public static void main(String[] args) {
        //创建对象: 空参构造方法
        MyClass02<String> mc = new MyClass02<>();
        //调用set方法赋值
        mc.setT("Hello World");
        //调用get方法获取数据
        String str = mc.getT();
        System.out.println(str);
        System.out.println(mc);
        System.out.println("----------");

        //创建对象: 满参构造方法
        //MyClass02<Student> mc2 = new MyClass02<>(new Student("张三",18));
        MyClass02<Integer> mc2 = new MyClass02<>(100);//内部发生自动装箱

        //调用get方法获取数据
        int num = mc2.getT();
        System.out.println(num);//100
        System.out.println(mc2);
    }
}
