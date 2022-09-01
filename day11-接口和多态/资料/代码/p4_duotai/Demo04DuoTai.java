package com.itheima.p4_duotai;

/*
    多态中的代码体现
        1.概念:
            同一行为，通过不同的事物，可以体现出来的不同的形态。多态，描述的就是这样的状态。
            java中的多态: 指的是对象具备多态性

        2.举例:
            假设学生Student类是人Person类的子类
            学生 是 一个学生
            //不是多态 左侧是Student类型,右侧是Student对象,左右一致
            Student stu = new Student();

            学生 是 一个人
            //是多态 左侧是Person类型,右侧是Student对象,左右不一致,左边是父类,右边是子类对象
            Person p = new Student();

        3.多态的前提:
            (1)必须要有继承或者接口实现
            (2)必须要有父类引用指向子类对象(父类类型的变量保存子类对象的地址值)
            (3)必须要有方法的覆盖重写,否则将失去多态的意义

        4.多态的本质
            (1)就是把子类对象当成父类类型使用
                父类引用指向子类对象(父类类型的变量保存子类对象的地址值)

            (2)多态的方式调用方法,方法跟着对象走
*/
public class Demo04DuoTai {
    public static void main(String[] args) {
        //多态的方式创建Person类的对象
        //场景: 哥们,帮响哥叫个人来
        Person p = new Student();
        //多态的方式调用方法
        p.eat();
        System.out.println("-----------");

        //场景: 刚才上一个哥们给响哥帮完忙了,我又说了一句
        //场景: 哥们,你回去后,再帮我叫个人来
        Person p2 = new Teacher();
        p2.eat();
    }
}
