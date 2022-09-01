package com.itheima.branch;

public class IfTest3 {
    public static void main(String[] args) {
        // 需求：模拟考试奖励机制
        // 1.定义一个变量，用来记录小明的考试成绩
        int score = 88;
        // 2.判断成绩所在的区间
        if (score >= 95 && score <= 100) {
            System.out.println("奖励自行车一辆");
        } else if (score >= 90 && score <= 94) {
            System.out.println("奖励游乐场游玩一次");
        } else if (score >= 80 && score <= 89) {
            System.out.println("奖励大黄蜂一个");
        } else if (score >= 0 && score < 80) {
            System.out.println("亲子教育一顿");
        } else {
            System.out.println("你的分数有误");
        }
    }
}
