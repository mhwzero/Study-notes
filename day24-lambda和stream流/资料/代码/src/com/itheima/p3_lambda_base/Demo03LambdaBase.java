package com.itheima.p3_lambda_base;
/*
    Lambda表达式的前提
        1.必须要有接口(函数式接口):
            该接口中必须被覆盖重写的抽象方法,只能有一个,可以有默认方法,可以有静态方法
        2.必须有方法使用函数式接口作为方法参数
    @Override: 检测子类方法是否是对父类方法的覆盖重写
    @FunctionalInterface: 检测是否是函数是接口的
 */
public class Demo03LambdaBase {
    public static void main(String[] args) {
        //1.调用方法传递匿名内部类对象
        print(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类方式...method...");
            }
        });
        System.out.println("---------------");
        //2.调用方法传递lambda表达式标准格式
        print(() -> {
                System.out.println("lambda表达式标准格式...method...");
            });
        System.out.println("---------------");
        //3.调用方法传递lambda表达式简化格式
        print(() -> System.out.println("lambda表达式简化格式...method..."));
    }

    //定义方法,使用函数式接口MyFunctionalInterface作为参数
    public static void print(MyFunctionalInterface mfi) {
        //调用抽象方法
        mfi.method();
        //调用默认方法
        mfi.show();
        //调用静态方法
        MyFunctionalInterface.fun();
    }
}
