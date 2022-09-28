package com.itheima.p1_lambda;
/*
    函数式思想则尽量忽略面向对象的复杂语法——强调做什么，而不是以什么形式做。

    lambda表达式书写规则:
        使用匿名内部类的方式中,只保留覆盖重写后方法的()和{},在()和{}之间,添加->,其它全部省略

        可以推导,就是可以省略
        行为参数化
        lambda表达式是对 匿名内部类的简化书写格式
 */
public class Demo01Lambda {
    public static void main(String[] args) {
        //调用方法传递接口Swimming的匿名内部类对象
        goSwimming(new Swimming() {
            @Override
            public void swim() {
                System.out.println("铁汁, 我们去游泳吧~");
            }
        });
        //调用方法传递lambda表达式
        goSwimming(() -> {
                    System.out.println("铁汁, 我们去游泳吧~");
                });
    }

    //定义方法使用游泳Swimming接口作为参数
    //方法参数是接口类型,调用方法时必须传递接口实现类匿名内部类对象
    public static void goSwimming(Swimming swimming) {
        //调用抽象方法
        swimming.swim();
    }
}
