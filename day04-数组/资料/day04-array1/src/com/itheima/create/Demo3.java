package com.itheima.create;

public class Demo3 {
    public static void main(String[] args) {
        // 需求：数组访问的注意事项
//        “数据类型[] 数组名”也可以写成 “数据类型 数组名[] ”。
        int[] ages = {18, 19, 21};
        int ages1[] = {18, 19, 21}; // 是为了兼容C/C++程序员，建议大家用上面那种方式

        double[] scores = new double[]{100, 59, 88, 79, 99.9};

        double scores1[] = new double[]{100, 59, 88, 79, 99.9};


//        什么类型的数组存放什么类型的数据，否则报错。
//        int[] ages2 = {18, 19, 21, 33.6, "黑马"};


//        数组一旦定义出来，程序执行的过程中，长度、类型就固定了。
        int[] ages3 = {18, 19, 21};

    }
}
