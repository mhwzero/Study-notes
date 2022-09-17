package com.itheima.p6_poker;
//定义类描述扑克牌
public class Poker {
    private int num;//表示当前扑克牌的大小
    private String content;//表示当前扑克牌的花色和数字 比如: ♥5,  ♦7

    public Poker(int num, String content) {
        this.num = num;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Poker{" +
                "num=" + num +
                ", content='" + content + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
