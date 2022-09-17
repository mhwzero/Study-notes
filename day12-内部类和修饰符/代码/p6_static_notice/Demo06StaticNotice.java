package com.itheima.p6_static_notice;
/*
    静态的内容只能使用静态的内容,不能使用非静态的内容
        1.解释:
            (1)静态当中不能使用非静态
            (2)静态的内容,是最先被加载到内存方法区中的静态区中,并完成初始化,
                但是此时没有对象(非静态的内容存在于对象中)既然没有对象,
                就不能使用非静态的内容
            (3)静态(先人),非静态(后人)

        2.静态的注意事项
            (1)静态方法可以直接访问静态变量和静态方法。
            (2)静态方法不能直接访问非静态成员变量或非静态成员方法。
            (3)反之，非静态成员方法可以直接访问静态变量或静态方法。
            (4)静态方法中，不能使用this关键字。

 */
public class Demo06StaticNotice {
    public static void main(String[] args) {
        //类名.静态方法
        //HMTeacher.showCountry();

        //对象名.非静态方法
        HMTeacher hmTeacher = new HMTeacher();
        hmTeacher.name = "宾哥";
        hmTeacher.showName();
    }
}
