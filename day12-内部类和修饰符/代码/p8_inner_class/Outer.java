package com.itheima.p8_inner_class;

/*
    内部类中3个重名变量的使用
        直接写变量名: 方法内部局部变量
        this.变量名: 内部类成员变量
        外部类名.this.变量名: 外部类成员变量
 */
public class Outer {//外部类
    int num = 10;
    //内部类也可以继承父类 和 实现接口
    public class Inner/* extends Object implements Serializable, Cloneable*/ {//内部类
        int num = 20;

        public void method() {
            int num = 30;
            //输出30
            System.out.println(num);//30
            //输出20
            System.out.println(this.num);//20
            //输出10
            System.out.println(Outer.this.num);//10
        }
    }
}
