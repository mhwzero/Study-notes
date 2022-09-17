package com.itheima.p7_set;
/*
    java.lang.Object类,成员方法:
        public native int hashCode(): 返回该对象的哈希码值,就是一个int数字
        该方法是本地方法,根据系统资源(对象的内存地址)计算一个int数字,叫做哈希值
        支持此方法是为了提高哈希表的性能。
    注意:
        1.同一对象,多次调用hashCode方法,要保证获取到的哈希值是相同的
        2.Object类中的hashCode方法,根据系统资源计算一个哈希值(int数字),
            所以只要new创建对象,获取到的哈希值就是不同的
        3.如果自己定义了的类,没有覆盖重写Object类中的hashCode方法,根据系统资源计算一个哈希值(int数字),
            所以只要new创建对象,获取到的哈希值就是不同的
        4.根据对String的测试,发现String类覆盖重写了Object类中的hashCode方法,
            根据字符串内容按照一定算法(存在漏洞)获取哈希值
        假设:
            String根据每个字符的ASCII码值,简单相加获取哈希值

            "abc"   的 哈希值       97 + 98 + 99 = 294
            "cab"   的 哈希值       99 + 97 + 98 = 294
        总结:
            1.哈希值不同,能否说明内容一定不同?
                肯定的,必须的
            2.哈希值相同,能否说明内容一定相同?
                不能的
                    继续调用equals方法
                        返回false: 内容不相同
                        返回true: 内容相同
    改口:
        以前调用toString方法,说返回的是对象的地址值
        但本质是对象的哈希值
 */
public class Demo08HashCode {
    public static void main(String[] args) {
        //创建Object类的对象
        Object obj1 = new Object();
        //调用hashCode方法
        int h1 = obj1.hashCode();
        System.out.println("h1 = " + h1);//356573597
        int h2 = obj1.hashCode();
        System.out.println("h2 = " + h2);//356573597

        //创建Object类的对象
        Object obj2 = new Object();
        //调用hashCode方法
        int h3 = obj2.hashCode();
        System.out.println("h3 = " + h3);//1735600054

        //打印引用变量,默认调用toString
        //toString结果:以后称为哈希码值
        System.out.println(obj1.toString());//java.lang.Object@1540e19d
        System.out.println(obj2.toString());//java.lang.Object@677327b6
        System.out.println("--------------------");

        //字符数组
        char[] chs = {'a','b','c'};

        //把字符数组转换成字符串
        String s1 = new String(chs);
        String s2 = new String(chs);
        //==: 比较内存地址
        System.out.println(s1 == s2);//false,说明s1和s2的内存地址不同
        System.out.println(s1.hashCode());//96354
        System.out.println(s2.hashCode());//96354

        System.out.println("重地".hashCode());//1179395
        System.out.println("通话".hashCode());//1179395
    }
}
