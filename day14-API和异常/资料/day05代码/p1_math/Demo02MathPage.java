package com.itheima.p1_math;

import java.util.Scanner;

/*
    注意:
        以上方法中必须掌握ceil方法
        后面学习分页查询
        假设每页显示条数固定的: 10条
        如果有100条数据: 10页
        如果有101条数据: 11页
        如果有99条数据: 10页

        [1][2][3]...[10]
 */
public class Demo02MathPage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入记录总条数: ");
        long totalCount = sc.nextLong();
        System.out.println("请输入每页显示记录数: ");
        int pageSize = sc.nextInt();

        //计算总页数
        int totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);
        System.out.println("总页数: " + totalPage);
    }
}
