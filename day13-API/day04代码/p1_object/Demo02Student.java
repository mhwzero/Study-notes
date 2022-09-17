package com.itheima.p1_object;
/*
    自定义类重写toString/equals方法
        1.重写toString方法
            目的: 返回对象的内容,而不是地址值
            快捷键: alt + insert --> toString --> 选择成员变量 --> ok
        2.重写equals方法:
            目的:比较对象的内容,而不是地址值
            快捷键: alt + insert --> equals && hashCode() --> 选择成员变量 --> ok
 */
public class Demo02Student {
    public static void main(String[] args) {
        //创建Student类的对象
        Student stu1 = new Student("张三", 18);
        Student stu2 = new Student("李四", 38);
        Student stu3 = new Student("张三", 18);
        /*
            Student类没有重写Object类的toString方法:
                com.itheima.p1_object.Student@1540e19d
                com.itheima.p1_object.Student@677327b6
                com.itheima.p1_object.Student@14ae5a5
            Student类重写Object类的toString方法:
                Student{name='张三', age=18}
                Student{name='李四', age=38}
                Student{name='张三', age=18}
         */
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
        System.out.println(stu3.toString());

        /*
            Student类没有重写Object类的equals方法:
                调用Object类的equals内部使用==比较对象的内存地址: false,false,false
            Student类重写Object类的equals方法:
                比较对象的内容,name相同并且age也相同,两个对象就是相同的: false,true,false
         */
        System.out.println(stu1.equals(stu2));
        System.out.println(stu1.equals(stu3));
        System.out.println(stu2.equals(stu3));
        System.out.println(stu3.equals(stu3));
        System.out.println(stu3.equals(null));
    }
}
