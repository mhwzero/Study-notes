package com.itheima.javabean;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：掌握标准javabean的书写要求
        User user1 = new User();
        user1.setName("Angelababy");
        user1.setAge(33);
        user1.setHeight(170);
        user1.setSalary(100000);

        System.out.println(user1.getName());
        System.out.println(user1.getAge());
        System.out.println(user1.getHeight());
        System.out.println(user1.getSalary());

        System.out.println("===========");
        User user2 = new User("蔡徐坤", 24, 180, 200000);
        System.out.println(user2.getName());
        System.out.println(user2.getAge());
        System.out.println(user2.getHeight());
        System.out.println(user2.getSalary());

    }
}
