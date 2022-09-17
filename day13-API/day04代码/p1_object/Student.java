package com.itheima.p1_object;

import java.util.Objects;

public class Student extends Object {
    private String name;
    private int age;

    /*
        调用Object类的toString返回对象地址没有意义
        需要返回对象的内容
        所以需要重写Object类的toString方法
        快捷键:
            alt + insert
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /*
        调用Object类的equals比较对象地址没有意义
        需要比较对象的内容
        所以需要重写Object类的equals方法
        认为: name相同并且age也相同,两个对象就是相同的
        快捷键:
            alt + insert
     */
    @Override
    public boolean equals(Object o) {
        /*
            this: 调用方法的对象
            o: 传递的参数对象
            this==o: 调用方法的对象和参数对象是同一个对象(自己和自己比),直接返回true
         */
        if (this == o) return true;
        /*
            o == null: 参数对象o是null,直接返回false
            ||: 短路的或者
            getClass() != o.getClass(): 反射中讲解,调用方法对象和参数对象不属于同一个类型的,直接返回false
         */
        //if (o == null || getClass() != o.getClass()) return false;
        //和上面是等价的
        if (o == null || !(o instanceof Student)) return false;
        //把参数对象强制类型转换成Student类型
        Student student = (Student) o;
        /*
            this.age == student.age: 调用方法的对象的age属性和方法参数对象的age属性相同
            &&: 逻辑与 并且
            Objects.equals(name, student.name):
                使用Objects类调用equals方法比较 调用方法的对象的name 和 方法参数对象的name 属性是否相同相同
         */
        //return age == student.age && Objects.equals(name, student.name);
        //和上面是等价的
        return age == student.age && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //空参/满参,set/get方法 自己生成
    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}