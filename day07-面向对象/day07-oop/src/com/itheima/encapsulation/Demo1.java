package com.itheima.encapsulation;

public class Demo1 {
    public static void main(String[] args) {
        // encapsulation: 封装
        // 目标：掌握如何更好地封装
        Student s1 = new Student();
//        s1.age = -121;
//        System.out.println(s1.age); // -121

        s1.setAge(-121);
        int age = s1.getAge();
        System.out.println(age);
    }
}
