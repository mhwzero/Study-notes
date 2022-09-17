package com.itheima.p3_baozhuang;
/*
    包装类的自动装箱拆箱
    自动装箱:
        基本类型数据,可以自动转换为对应的引用类型(包装类),是自动完成滴,不需要代码特殊处理

    自动拆箱:
        引用类型数据(包装类),可以自动转换为对应的基本类型,是自动完成滴,不需要代码特殊处理
 */
public class Demo06AutoBox {
    public static void main(String[] args) {
        //不建议使用
        Integer i1 = new Integer(300);
        System.out.println(i1);//300
        /*
            javac编译: 底层优化处理
            底层原理:
                Integer.valueOf(300)
         */
        Integer i2 = 300;//发生自动装箱
        System.out.println(i2);//300

        /*
            valueOf方法的底层原理:
                调用构造方法创建Integer类的对象
                new Integer(300)
         */
        Integer i3 = Integer.valueOf(300);
        System.out.println(i3);//300

        /*
            javac编译: 底层优化处理
            底层原理:
                调用Integer类的成员方法intValue
                返回Integer对象i1中封装的int数据value的值
                i1.intValue()
         */
        int num = i1;
        System.out.println(num);//300

        Integer i4 = 300;//发生自动装箱

        /*
            先把i4进行拆箱: i4.intValue() 得到结果300
            再计算300+200 得到结果500
            最后把结果数据装箱: new  Integer(500)
         */
        Integer i5 = i4 + 200;
        System.out.println(i5);
    }
}
