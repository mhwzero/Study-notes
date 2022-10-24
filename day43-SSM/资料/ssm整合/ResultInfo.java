package com.itheima.vo;

import lombok.Data;

import java.io.Serializable;

//通用返回结果，服务端响应的数据最终都会封装成此对象
@Data
public class ResultInfo implements Serializable {
    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private Object data; //数据

    //成功结果
    public static ResultInfo success(Object object) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.data = object;
        resultInfo.code = 1;
        return resultInfo;
    }

    //失败结果
    public static ResultInfo error(String msg) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.msg = msg;
        resultInfo.code = 0;
        return resultInfo;
    }
}