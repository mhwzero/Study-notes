package com.itheima.p7_set;
/*
    String类的hashCode方法源码分析:
        public int hashCode() {
            int h = hash;
            if (h == 0 && value.length > 0) {
                char val[] = value;

                for (int i = 0; i < value.length; i++) {
                    h = 31 * h + val[i];
                }
                hash = h;
            }
            return h;
        }
        以上方法中的hash是String类的int类型成员变量,创建String的对象后hash的值是0
        以上方法中的value是String内部保存数据的字符数组,此处{'a','b','c'}
        第一次:
            h = 31 * h + val[0] = 31*0 + 97 = 97
        第二次:
            h = 31 * h + val[1] = 31*97 + 98 = 3105
        第三次:
            h = 31 * h + val[2] = 31*3105 + 99 = 96354

        最后:
            把h的值赋值给hash

 */
public class Demo09StringHashCode {
    public static void main(String[] args) {
        System.out.println("abc".hashCode());//96354
        System.out.println(31*3105 + 99);
    }
}
