package com.itheima.log;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Logger {

    public void m1() {
        System.out.println("进入方法" + new Date().toLocaleString());
    }

    public void m2() {
        System.out.println("离开方法" + new Date().toLocaleString());
    }

    public void m3() {
        System.out.println("方法出现异常" + new Date().toLocaleString());
    }
}
