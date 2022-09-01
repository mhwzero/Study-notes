package com.itheima.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        // 需求：根据学号到集合中查找学生对象
        // 1.定义一个学生类

        // 2.定义一个集合，用来存储一批学生对象
        ArrayList<Student> students = new ArrayList<>();

        // 3.创建学生对象，添加到集合中
//        Student s1 = new Student(1, "叶孤城", 18, "护理一班");
//        Student s2 = new Student(2, "东方不败", 19, "推拿二班");
//        Student s3 = new Student(3, "西门吹雪", 16, "中药学四班");
//        Student s4 = new Student(4, "梅超风", 17, "神经科二班");

        students.add(new Student(1, "叶孤城", 18, "护理一班"));
        students.add(new Student(2, "东方不败", 19, "推拿二班"));
        students.add(new Student(3, "西门吹雪", 16, "中药学四班"));
        students.add(new Student(4, "梅超风", 17, "神经科二班"));

        // 4.展示学生信息
        System.out.println("学号\t姓名\t\t年龄\t\t班级");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getAge() + "\t\t" + student.getClassName());
        }

        // 定义方法，根据学号查找学生对象
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请您输入要查找学生的学号：");
            int id = scanner.nextInt();
            Student student = getStudentById(students, id);

            if (student == null) {
                // 没找到，重新输入
                System.out.println("您查找的学号不存在，请重新输入一个学号查找：");
            } else {
                // 找到了
                System.out.println("您找到的学生信息如下：");
                System.out.println("学号\t姓名\t\t年龄\t\t班级");
                System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getAge() + "\t\t" + student.getClassName());
                break;
            }
        }

    }

    public static Student getStudentById(ArrayList<Student> students, int id) {
        // 遍历学生集合
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            // 判断当前学生的学号和要查找的学号是否一致
            if (student.getId() == id) {
                // 找到了
                return student;
            }
        }
        // 没找到
        return null;
    }
}
