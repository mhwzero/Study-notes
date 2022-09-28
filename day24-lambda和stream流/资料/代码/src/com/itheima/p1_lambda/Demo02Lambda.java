package com.itheima.p1_lambda;
/*
    Lambda表达式的标准格式
        1.lambda表达式的组成
            (1)一个箭头:    ->
            (2)一些参数:    ()内部可以写参数
            (3)一段代码:    {}中的内容

        2.标准格式:
            (参数类型 参数名称) -> { 代码语句 }

        3.格式解释:
            (1)小括号(): 就是以前定义方法的小括号,内部写的是方法参数列表
                        没有参数,也不能省略
            (2)箭头->: 代表方法的参数传递
            (3)大括号{}:  就是以前定义方法的{},代表方法体,方法的功能代码

 */
public class Demo02Lambda {
    public static void main(String[] args) {
        //1.匿名内部类对象的方式,创建并开启线程
        //通过匿名内部类对象的方式,给Thread对象,传递一段代码执行
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程任务A执行了.....");
            }
        }).start();

        //2.lambda表达式的方式
        //通过lambda表达式的方式,给Thread对象,传递一段代码执行
        new Thread(()->{
            System.out.println("线程任务B执行了....");
        }).start();
    }
}
