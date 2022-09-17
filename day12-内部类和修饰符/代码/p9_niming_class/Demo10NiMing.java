package com.itheima.p9_niming_class;
/*
    匿名内部类对象
    1.概念:
        是内部类的简化写法。它的本质是一个 带具体实现的 父类或者父接口的 匿名的 子类对象。

    2.作用:
        (1)是一种创建接口实现类对象的快捷方式
            把创建实现类,覆盖重写抽象方法,创建实现类对象,实现类对象调用方法这四步合成一步完成

        (2)是一种创建抽象父类的子类对象的快捷方式
            把创建子类,覆盖重写抽象方法,创建子类对象,子类对象调用方法这四步合成一步完成

    3.匿名内部类对象创建格式:
        new 抽象父类/接口(); //错误: 不能直接new抽象父类/接口的对象

        new 抽象父类/接口() {
            覆盖重写所有的抽象方法;
        }

        注意:
            (1)上面只是创建了一个抽象父类的子类对象或者接口的实现类对象
            (2)该对象目前没有名字
            (3)该对象所属的类是没有名字的
                (注意:其实有名字(外部类名$1.class),只是该名字不是我们起的,是JVM帮助我们起的)
*/
public class Demo10NiMing {
    public static void main(String[] args) {
        //直接创建FlyAble接口的匿名内部类对象
        /*
            注意:
                1.下面的代码是FlyAble接口的实现类对象
                2.只不过实现类的名字是由JVM内部指定的,我们看不见,而且不能直接使用JVM生成的类名
                3.该对象没有名字
         */
        new FlyAble(){
            @Override
            public void fly() {
                System.out.println("老鹰在高空飞翔....");
            }
        };
        System.out.println("----------");
        //直接创建FlyAble接口的匿名内部类对象同时调用方法
        new FlyAble(){
            @Override
            public void fly() {
                System.out.println("蝴蝶在高空飞翔....");
            }
        }.fly();
        System.out.println("----------");

        //多态的方式创建FlyAble接口的匿名内部类对象
        FlyAble flyAble = new FlyAble() {
            @Override
            public void fly() {
                System.out.println("C919大飞机在高空飞翔....");
            }
        };

        for (int i = 0; i < 10; i++) {
            flyAble.fly();
        }
    }
}
