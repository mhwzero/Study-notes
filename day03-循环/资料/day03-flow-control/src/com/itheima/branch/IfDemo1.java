package com.itheima.branch;

public class IfDemo1 {
    public static void main(String[] args) {
        // 目标：掌握if分支的三种写法，并理解其执行流程
        // 格式一： if(条件表达式) {语句体};
        // 假设心跳数据在60-120之间是正常的，此外，需要提示进一步检查
        int heartBeat = 100;
        if (heartBeat < 60 || heartBeat > 120) {
            System.out.println("您的心跳数据不正常，请进一步检查");
        }
        System.out.println("检查结束");

        // 格式二：if(条件表达式) {语句体1} else {语句体2};
        // 模拟发红包
        double money = 9.9;
        if (money > 520) {
            System.out.println("红包发送成功");
        } else {
            System.out.println("余额不足，分手吧");
        }

        // 格式三：if(条件表达式) {语句体1} else if(条件表达式2) {语句体2} else if(条件表达式3) {语句体3}... else {语句体n+1};
        // 模拟公司绩效系统
        // 分数在90-100 A
        // 分数在80-89 B
        // 分数在70-79 C
        // 分数在60-69 D
        // 分数在60分以下 D-
        int score = 59;
        if (score >= 90 && score <= 100) {
            System.out.println("您的绩效是：A");
        } else if (score >= 80 && score <= 89) {
            System.out.println("您的绩效是：B");
        } else if (score >= 70 && score <= 79) {
            System.out.println("您的绩效是：C");
        } else if (score >= 60 && score <= 69) {
            System.out.println("您的绩效是：D");
        } else if (score >= 0 && score <= 59) {
            System.out.println("您的绩效是：D-");
        } else {
            System.out.println("您的分数输入错误");
        }
    }
}
