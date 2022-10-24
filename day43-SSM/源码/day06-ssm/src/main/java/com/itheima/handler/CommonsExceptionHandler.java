package com.itheima.handler;

import com.itheima.vo.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class CommonsExceptionHandler {

    //异常处理
    @ExceptionHandler(Exception.class)
    public ResultInfo handlerException(Exception e) {
        //1. 打印
        e.printStackTrace();

        //2. 返回结果
        return ResultInfo.error("服务器开小差了....");
    }

}
