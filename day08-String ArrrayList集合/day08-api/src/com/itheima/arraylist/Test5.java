package com.itheima.arraylist;

import java.util.ArrayList;

public class Test5 {
    public static void main(String[] args) {
        // 需求：模拟电影信息展示，这里重点掌握ArrayList集合中存储自定义类型对象
        // 1.创建一个电影类

        // 2.定义一个ArrayList集合，用来存储三部电影信息
        ArrayList<Movie> movies = new ArrayList<>();

        // 3.初始化三部电影信息
//        Movie m1 = new Movie("阿甘正传", 9.5, "汤姆汉克斯");
//        Movie m2 = new Movie("霸王别姬", 9.3, "张国荣/张丰毅");
//        Movie m3 = new Movie("肖申克的救赎", 9.7, "蒂姆罗宾斯");

        // 4.将三部电影信息放到集合中
        movies.add(new Movie("阿甘正传", 9.5, "汤姆汉克斯"));
        movies.add(new Movie("霸王别姬", 9.3, "张国荣/张丰毅"));
        movies.add(new Movie("肖申克的救赎", 9.7, "蒂姆罗宾斯"));

        // 5.遍历集合，展示三部电影信息
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            System.out.println("片名：" + movie.getName());
            System.out.println("评分：" + movie.getScore());
            System.out.println("主演：" + movie.getActor());
            System.out.println("===================");
        }
    }
}
