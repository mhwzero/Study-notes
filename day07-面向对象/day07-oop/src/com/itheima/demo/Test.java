package com.itheima.demo;

public class Test {
    public static void main(String[] args) {
        // 需求：模拟展示三部电影信息
        // 1.定义一个电影类

        // 2.创建三部电影对象
        Movie m1 = new Movie("《长津湖》", 9.7 ,  "吴京");
        Movie m2 = new Movie("《我和我的父辈》", 9.6 ,  "吴京");
        Movie m3 = new Movie("《扑水少年》", 9.5 ,  "王川");

        // 3.定义一个数组，用来存储三部电影对象
        Movie[] movies = {m1, m2, m3};

        // 4.遍历数组，展示三部电影信息
        for (int i = 0; i < movies.length; i++) {
            Movie movie = movies[i];
            System.out.println("片名：" + movie.getName());
            System.out.println("评分：" + movie.getScore());
            System.out.println("主演：" + movie.getActor());
            System.out.println("=============");
        }
    }
}
