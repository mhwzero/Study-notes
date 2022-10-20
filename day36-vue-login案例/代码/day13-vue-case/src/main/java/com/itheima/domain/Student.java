package com.itheima.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String id;  //学号
    private String name;    //姓名
    private String birthday;  //生日
    private String address; //地址
}
