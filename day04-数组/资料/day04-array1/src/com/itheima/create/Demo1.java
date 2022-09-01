package com.itheima.create;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：掌握数组的静态初始化
        // 静态初始化的完整格式
        // 数据类型[] 数组名 = new 数据类型[]{元素1, 元素2, ...};

        int[] ages = new int[]{18, 19, 17, 18, 20, 22};
        double[] scores = new double[]{100, 59, 88, 79, 99.9};
        String[] names = new String[]{"Angelababy", "杨紫", "张歆艺", "迪丽热巴", "王心凌"};

        // 静态初始化的简化格式，建议使用简化格式
        // 数据类型[] 数组名 = {元素1, 元素2, ...};
        int[] ages1 = {18, 19, 17, 18, 20, 22};
        double[] scores1 = {100, 59, 88, 79, 99.9};
        String[] names1 = {"Angelababy", "杨紫", "张歆艺", "迪丽热巴", "王心凌"};

        // 数组名中存储的是一个地址值，数组是一个引用数据类型
        System.out.println(ages);   // [I@119d7047
        System.out.println(scores); // [D@776ec8df
    }
}
