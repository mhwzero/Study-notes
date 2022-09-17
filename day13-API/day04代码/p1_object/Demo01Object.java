package com.itheima.p1_object;
/*
    Object类的介绍和使用
    1.java.lang.Object类的介绍:
        是整个类的体系结构中的最顶层父类,是所有类的最终父类,它里面定义的方法,其它类都有.
        类Object是类层次结构的根类。每个类都使用Object作为超类。所有对象（包括数组）都实现这个类的方法。
    2.常用方法:
        (1)public String toString(): 返回调用方法的对象的字符串表示形式
            字符串形式： 理解位返回对象的地址值,类的全名称 + @ + 16进制的int数字
            内部源代码分析:
            public String toString() {
                return getClass().getName() + "@"
                    + Integer.toHexString(hashCode());
            }
            getClass().getName(): 获取类的全名称
            Integer.toHexString(hashCode()): 把对象的哈希值转换成16进制的int数字
        (2)public boolean equals(Object obj): 比较调用方法的对象和方法参数对象是否相等
            true: 说明相等
            false: 说明不相等
            默认比较对象的地址值,然而只要new对象的地址值就是不相同
            内部源代码分析:
            public boolean equals(Object obj) {
                return (this == obj);
            }
            this代表: 调用方法的对象
            obj代表: 调用方法时传递的参数对象
            ==: 在比较两个对象的内存地址值是否相同
 */
public class Demo01Object {
    public static void main(String[] args) {
        //创建Object类的对象
        Object obj1 = new Object();
        //调用toString方法
        String s1 = obj1.toString();
        System.out.println(s1);//内存地址值: java.lang.Object@1540e19d
        /*
            toString方法源码:
                obj1.getClass().getName(): 获取当前对象所属类的全名称        后面反射中讲解
                Integer.toHexString(obj1.hashCode()): 根据对象获取一个int数字并转换成16进制   后面讲
         */
        System.out.println(obj1.getClass().getName() + "@" + Integer.toHexString(obj1.hashCode()));
        //对象调用toString方法获取字符串,然后输出字符串
        System.out.println(obj1.toString());//内存地址值: java.lang.Object@1540e19d
        //println方法参数传递引用变量: println内部会使用引用变量调用toString方法
        System.out.println(obj1);//内存地址值: java.lang.Object@1540e19d
        System.out.println("--------------");

        //创建Object类的对象
        Object obj2 = new Object();
        /*
            ==的使用:
                1.基本类型: 比较具体的数据值是否相同
                2.引用类型: 比较的是内存地址值是否相同
            注意:
                只要使用new创建对象,内存地址和谁都不一样
         */
        System.out.println(obj1 == obj2);//false
        /*
            equals方法内部原理:
                默认使用==比较对象的内存地址值
            然而obj1和obj2都是new的,地址都不一样
         */
        System.out.println(obj1.equals(obj2));//false
    }
}
