package com.itheima.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Logger {

//    public void m1() {
//        System.out.println("即将进入方法了");
//    }
//
//    public void m2() {
//        System.out.println("方法正常返回");
//    }
//
//    public void m3() {
//        System.out.println("方法抛出异常");
//    }
//
//    public void m4() {
//        System.out.println("无论如何都会执行");
//    }
    public Object m5(ProceedingJoinPoint pjp) {
        Object obj = null;

        try {
            System.out.println("即将进入方法了");

            //切点执行位置
            obj = pjp.proceed();

            System.out.println("方法正常返回");

        } catch (Throwable e) {
            System.out.println("方法抛出异常");
        } finally {
            System.out.println("无论如何都会执行");
            return obj;
        }
    }

}
