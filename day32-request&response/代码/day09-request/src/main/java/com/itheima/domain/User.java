package com.itheima.domain;

import lombok.Data;

//类中的属性必须跟map中得key是一样的
@Data
public class User {
    private String name;
    private String age;
    private String[] hobby;
}
