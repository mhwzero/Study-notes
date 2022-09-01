package com.itheima.create;

public class Demo5 {
    public static void main(String[] args) {
        // 需求：了解动态初始化数组后元素的默认值
        // 整数类型
        byte[] b1 = new byte[10];
        System.out.println(b1[0]);  // 0
        System.out.println(b1[9]);  // 0

        long[] l1 = new long[10];
        System.out.println(l1[0]);  // 0

        // 小数类型
        double[] d = new double[10];
        System.out.println(d[0]);   // 0.0
        System.out.println(d[9]);   // 0.0

        // boolean
        boolean[] b = new boolean[10];
        System.out.println(b[0]);   // false

        char[] c = new char[10];
        System.out.println(c[0] + 0);   // 0
        System.out.println((int) c[9]); // 0

//        char c1 = 'a';
//        System.out.println(c1); // a
//        System.out.println(c1 + 1); // 98

        // String
        String[] strs = new String[10];
        System.out.println(strs[0]);    // null
        System.out.println(strs[9]);

//        int[] ages = new int[3]{18, 19 , 20};

    }
}
