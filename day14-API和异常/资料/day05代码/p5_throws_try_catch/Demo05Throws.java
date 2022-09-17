package com.itheima.p5_throws_try_catch;
/*
    异常处理方式一:
        使用throws关键字: 声明抛出异常
            告诉方法的调用者,你调用我的方法时,我方法内部有可能会产生什么样子的异常,
            方法内部没有处理,谁调用我谁来处理
        使用格式:
            修饰符 返回值类型 方法名称(形式参数列表....) throws 异常类 {
                方法体;
            }
        场景:
            项目经理:   JVM
            项目组长:   main方法
            程序猿:     sports方法
        注意:
            1.throws关键字必须写在方法声明的后面
            2.throws关键字后面跟的是异常类,而且可以写多个
            3.throw必须使用在方法内部
            4.throw后面必须写异常对象,而且只能写一个
            5.throw表示把一个具体的异常对象抛出给该方法的调用者
*/
public class Demo05Throws {
    public static void main(String[] args) throws Exception {
        System.out.println("组长安排程序员跑圈开始....");
        sports(5);
        System.out.println("组长安排程序员跑圈结束....");
    }
    //模拟程序猿锻炼身体: 跑圈
    public static void sports(int num) throws Exception {
        System.out.println("已经跑了3圈....");
        if (num > 3) {
            throw new Exception("心脏病发作....");
        }
    }
}
