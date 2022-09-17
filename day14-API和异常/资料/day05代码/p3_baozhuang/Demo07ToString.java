package com.itheima.p3_baozhuang;

/*
    基本类型int 转换成 String
        1.最简单/最常用的方式:
            基本类型int数据  + ""     借助+进行字符串拼接

        2.思考: String类中有没有参数是int类型,返回值是String类型方法?
            public static String valueOf(int i): 把方法参数int数据i,转换成String类型并返回

        3.思考: Integer类中有没有参数是int类型,返回值是String类型方法?
            public static String toString(int i)
*/
public class Demo07ToString {
    public static void main(String[] args) {
        int a = 10;
        //把int数据转换成String
        String s = a + "";
        System.out.println(s + 10);//1010

        //String类的静态方法,把int数字转成字符串
        String s1 = String.valueOf(10);
        System.out.println(s1 + 10);//1010

        String s2 = Integer.toString(10);
        System.out.println(s2 + 10);//1010

    }
}
