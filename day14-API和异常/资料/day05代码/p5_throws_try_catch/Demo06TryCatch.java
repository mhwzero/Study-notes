package com.itheima.p5_throws_try_catch;

/*
    异常处理方式二: 捕获处理
        try - catch 捕获处理
        使用格式:
            try {
                有可能产生异常的代码;
            } catch(异常类 对象名) {
                处理异常的代码;
            }

        try: {}中的内容,相当于教室,走廊
        catch:()中的内容,烟雾报警器
        catch:{}中的内容,消防栓,消防官兵

        try-catch的执行流程:
            1.try中没有产生异常,程序正常执行,catch中代码不执行
            2.try中的产生异常,try中产生异常的位置后续代码不再执行
                (1)有catch捕获
                    a.如果catch成功捕获,执行{}中处理异常的代码,处理完毕后,程序继续执行
                    b.如果catch没有成功捕获,继续抛出异常,抛给JVM,JVM采用中断处理
                (2)没有catch捕获 继续抛出
        场景:
            项目经理:   JVM
            项目组长:   main方法
            程序猿:     sports方法
 */
public class Demo06TryCatch {
    public static void main(String[] args) {
        System.out.println("组长安排程序员跑圈开始....");
        try {
            sports(3);
        } catch (Exception e) {
            //Exception e = new Exception("心脏病发作...."); 赋值成功,说明异常被正确捕获
            //在try中一旦产生异常,该异常会被抓到后赋值给catch()中异常变量
            //赋值成功,说明异常被获取到了,是要处理的异常,就会执行catch后面{}中的代码
            //一旦执行catch后面{}中的代码,说明问题被解决了
            System.out.println("哥们辛苦,赶紧来点速效救心丸....");
        }
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
