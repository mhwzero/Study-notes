package com.itheima.p1_extends;
/*
    继承:
        格式:
            public class 父类 {
                //成员变量
                //成员方法
                //构造方法
            }

            public class 子类 extends 父类 {
                //成员变量
                //成员方法
                //构造方法
            }

            public class A extends B {
                //...
            }

        注意:
            1.B是父类,又叫做基类/超类,A是子类
            2.子类可以使用父类中除了private修饰的和构造方法以外的内容
 */
public class Demo01Extends {
    public static void main(String[] args) {
        //创建子类对象
        Teacher t = new Teacher();

        //给成员变量赋值
        t.name = "响哥哥";
        t.age = 18;
        t.salary = 66666;

        //调用成员方法
        t.showInfo();
        t.teaching();
        System.out.println("-------------");
        //创建子类对象
        Manager m = new Manager();

        //给成员变量赋值
        m.name = "宾哥哥";
        m.age = 16;
        m.salary = 88888;

        //调用成员方法
        m.showInfo();
        m.managerClass();

    }
}
