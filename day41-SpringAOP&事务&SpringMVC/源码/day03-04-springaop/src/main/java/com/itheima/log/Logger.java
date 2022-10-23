package com.itheima.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MemberSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
@Aspect//切面
public class Logger {

    //配置切点
    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    public void pt() {
    }

    //执行时间  类  方法   参数  结果  异常
    //环绕通知
    @Around("pt()")
    public Object m5(ProceedingJoinPoint pjp) {//pjp切点方法
        Object obj = null;

        System.out.println("执行时间:" + new Date().toLocaleString());
        System.out.println("类名:" + pjp.getTarget().getClass().getName());
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        System.out.println("方法名:" + methodSignature.getMethod().getName());

        System.out.println("参数:" + Arrays.toString(pjp.getArgs()));
        try {

            //切点执行位置
            obj = pjp.proceed();

            System.out.println("结果:" + obj);
        } catch (Throwable e) {
            System.out.println("异常信息:" + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            return obj;
        }
    }

//    //环绕通知
//    @Around("pt()")
//    public Object m5(ProceedingJoinPoint pjp) {
//        Object obj = null;
//
//        try {
//            System.out.println("即将进入方法了");
//
//            //切点执行位置
//            obj = pjp.proceed();
//
//            System.out.println("方法正常返回");
//
//        } catch (Throwable e) {
//            System.out.println("方法抛出异常");
//        } finally {
//            System.out.println("无论如何都会执行");
//            return obj;
//        }
//    }


//    @Before("pt()") //被标注的方法会在那个切点之前执行
//    public void m1() {
//        System.out.println("即将进入方法了");
//    }
//
//    @AfterReturning("pt()")
//    public void m2() {
//        System.out.println("方法正常返回");
//    }
//
//    @AfterThrowing("pt()")
//    public void m3() {
//        System.out.println("方法抛出异常");
//    }
//
//    @After("pt()")
//    public void m4() {
//        System.out.println("无论如何都会执行");
//    }

}
