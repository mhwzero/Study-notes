package com.itheima.demo01;
/*
    1.要求:定义一个Student类
		属性:
			String name  姓名
			String no 	 班号
			double score 成绩
 */
public class Student {
    private String name;
    private String no;
    private double score;

    public Student() {
    }

    public Student(String name, String no, double score) {
        this.name = name;
        this.no = no;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
