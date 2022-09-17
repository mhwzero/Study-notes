package com.itheima.p8_inner_class;
/*
    成员内部类(和成员变量/成员方法 处于同一位置)
    1.定义格式:
        public class 外部类名 {//外部类
            //外部类成员变量
            //外部类成员方法
            //外部类构造方法
            //成员内部类
            public class 内部类名 {
                //内部类成员变量
                //内部类成员方法
                //内部类构造方法
            }
        }

    2.成员内部类的使用格式:
        (1)外部类要访问内部类的成员，必须要建立内部类的对象。
            外部类.内部类 对象名 = 外部类对象.new 内部类();
            外部类.内部类 对象名 = new 外部类().new 内部类();
            简单来讲: 外.内 对象名 = new 外().new 内();

        (2)内部类可以直接访问外部类的成员，包括私有成员。

    3.注意:
        (1)内部类也是类,编译后也有对应的class文件: 外部类名$内部类名.class
        (2)内部类可以使用public修饰,也可以使用private修饰,还可以使用static修饰
        (3)可以在方法内部定义内部类(局部内部类),出了方法就失效了(必须在方法内部创建内部类的对象并使用)
*/
public class Demo08InnerClass {
    public static void main(String[] args) {
        //创建外部类Person的对象
        Person p = new Person();
        System.out.println(p.age);//18
        //创建内部类的对象: 外部类对象.new 内部类名(参数...)
        Person.Heart heart = p.new Heart();
        //使用内部类对象调用方法
        heart.jump();
        System.out.println("-----------");

        //使用Person类的匿名对象直接调用age属性
        //注意匿名对象: 只能被使用一次
        System.out.println(new Person().age);

        //直接创建成员内部类的对象
        //创建内部类的对象:  new 外部类名(参数...).new 内部类名(参数...)
        Person.Heart heart2 = new Person().new Heart();
        heart2.jump();
        System.out.println("-----------");

        //创建外部类的对象
        Outer outer = new Outer();
        //创建内部类对象
        Outer.Inner inner = outer.new Inner();
        //使用内部类对象调用方法
        inner.method();
    }
}
