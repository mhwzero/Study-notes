package com.itheima.p4_generic_interface;
/*
    泛型: jdk1.5添加的新特性

    泛型接口: 看MyClass05
        定义接口时,该接口中需要处理某种类型的数据,但是什么类型,不确定,所以定义成泛型
        泛型变量一般用大写字母表示:
            T(Type),E(Element),K(Key),V(Value)

    定义接口的定义格式:
        public interface 接口名称<泛型变量> {
            ...
        }
        举例:
        public interface 接口名称<T> {
            ...
        }

    接口上定义的泛型,什么时间确定具体的类型呢?
        1.实现类实现接口时,确定接口上泛型的具体类型的话,
            直接指定具体类型

        2.定义实现类时,也不确定接口上的泛型
            该实现类必须定义为泛型类
            而且实现类上的泛型和接口上的泛型要保持一致
            创建实现类对象时,确定具体的类型
 */
public class Demo04GenericInterface {
    public static void main(String[] args) {
        MyInterImplA mia = new MyInterImplA();
        mia.method("Hello World");

        MyInterImplB<String> mib = new MyInterImplB<>();
        mib.method("Java");
    }
}
