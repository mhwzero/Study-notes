package com.itmhw.handler;

import com.itmhw.vo.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class CommonsExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResultInfo handlerException(Exception e){
        //1.打印
        e.printStackTrace();
        //返回结果
        return ResultInfo.error("服务器蹦了");
    }
}
