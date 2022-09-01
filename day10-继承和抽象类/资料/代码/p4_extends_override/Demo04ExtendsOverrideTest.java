package com.itheima.p4_extends_override;
/*
    方法重写的应用_手机类的代码实现
        1.定义老款手机OldPhone类
            成员方法: 打电话,发短信,显示来电
        2.创建老款手机OldPhone类的对象
        3.使用老款手机OldPhone类的对象调用成员方法
        4.定义新款手机NewPhone类 继承 老款手机OldPhone类
            成员方法: 打电话(直接使用父类的),发短信(直接使用父类的),来电显示(功能增强,覆盖重写父类的)
        5.创建新款手机NewPhone类的对象np
        6.使用新款手机NewPhone类的对象np调用成员方法

    this和super总结?
        1.成员变量:
            this.成员变量: 子类自己的成员变量,没有找父类
            super.成员变量: 父类自己的成员变量,没有找父类
        2.成员方法:
            this.成员方法(参数列表...): 子类自己的成员方法,没有找父类  千万不要出现自己调用自己的情况
            super.成员方法(参数列表...): 父类自己的成员方法,,没有找父类
 */
public class Demo04ExtendsOverrideTest {
    public static void main(String[] args) {
        //2.创建老款手机OldPhone类的对象
        OldPhone op = new OldPhone();

        //3.使用老款手机OldPhone类的对象调用成员方法
        op.call("林志颖");
        op.sendMessage("林志颖","好了吗?");
        op.show();
        System.out.println("----------");

        //5.创建新款手机NewPhone类的对象np
        NewPhone np = new NewPhone();

        //6.使用新款手机NewPhone类的对象np调用成员方法
        np.call("柳岩");
        np.sendMessage("柳岩","最近忙吗? 强哥比较郁闷");
        np.show();
    }
}
