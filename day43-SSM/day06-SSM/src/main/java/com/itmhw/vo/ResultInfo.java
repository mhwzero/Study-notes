package com.itmhw.vo;

import lombok.Data;

import java.io.Serializable;

//通用返回结果，服务端响应的数据最终都会封装到此对象中
@Data
public class ResultInfo implements Serializable {
    private Integer code; //编码，成功为1,0和其他数字为失败
    private String msg; //错误信息
    private Object data; //数据

    private ResultInfo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResultInfo() {}
    public static ResultInfo success(Object Object){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.code = 1;
        resultInfo.data=Object;
        return  resultInfo;
    }
    public static ResultInfo error(String msg){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.code=0;
        resultInfo.msg = msg;
        return resultInfo;
    }
}
