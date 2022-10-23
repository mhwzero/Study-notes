package com.itheima.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice //此注解标注在类上,用于声明这是一个全局异常处理类
@ResponseBody
public class CommonExceptionHandler {

    //处理异常的方法
    @ExceptionHandler(value = Exception.class)//此注解用于指定当前方法可以处理的异常类型
    public String handlerException(Exception e) {
        //1. 记录异常信息
        e.printStackTrace();

        //2. 返回错误提示
        return "NETWORK ERROR";
    }

    //处理异常的方法
    @ExceptionHandler(value = NullPointerException.class)
    public String handlerNullPointerException(Exception e) {
        //1. 记录异常信息
        System.out.println("给张三发个邮件");

        //2. 返回错误提示
        return "NETWORK ERROR";
    }

    //处理异常的方法
    @ExceptionHandler(value = ArithmeticException.class)
    public String handlerArithmeticException(Exception e) {
        //1. 记录异常信息
        System.out.println("给李四发个邮件");

        //2. 返回错误提示
        return "NETWORK ERROR";
    }
}
