package com.itheima.memory;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "小明";
        s1.gender = '男';
        s1.hobby = "游戏、睡觉、听课";
        s1.study();

        Student s2 = s1;
        s2.hobby = "爱提问";

        System.out.println(s2.name);
        System.out.println(s2.gender);
        System.out.println(s1.hobby);
        s2.study();
    }
}
