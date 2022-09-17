package com.itheima.demo01;

import java.util.ArrayList;
import java.util.List;

/*
    定义班级类:
    1.班号
    2.多个学生List集合中,泛型Student
    3.总分:double total
 */
public class ClassRoom {
    private String no;
    private List<Student> list;
    private double total;
    //空参构造
    public ClassRoom() {
        list = new ArrayList<>();
    }
    //带参数的构造方法
    public ClassRoom(String no) {
        this();//调用本类构造方法
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
