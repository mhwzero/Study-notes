package com.itheima.p1_interface;
/*
    1.定义格式
        public static 返回值类型 方法名称(形式参数列表...) {
            方法体;
       }
    2.使用格式: 只能使用接口名称调用接口中的静态方法
    3.注意:
        (1)接口中的静态方法,属于接口本身,与实现类无关,在实现类中不存在覆盖重写
        (2)类中的静态方法,属于类本身,与接口无关,与对象无关
        (3)类中的静态方法:
             类名直接调用 ---推荐使用
             对象直接调用 ---不推荐使用
    总结: 静态的内容要么用接口名称调用,要么用类名称调用
*/
public class Demo03InterfaceStatic {
    public static void main(String[] args) {
        //只能使用接口名称调用接口内部的静态方法
        USB.thanks();

        //只能使用类名称调用类内部的静态方法
        HMScanner.thanks();

        HMScanner hmScanner = new HMScanner();
        //对象.静态方法(...): 不推荐使用,内部仍然使用类名调用静态方法
        hmScanner.thanks();//只是一个表象,内部编译后会变成HMScanner.thanks()
    }
}
