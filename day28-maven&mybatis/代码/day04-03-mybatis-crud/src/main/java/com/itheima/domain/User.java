package com.itheima.domain;

import lombok.Data;

import java.util.Date;

//ORM   Object(类型) Relational(数据库)  Mapping  对象关系映射
@Data
public class User {
    private Integer uid;
    private String name;
    private String password;
    private String email;
    private Date birthday; //注意类型和包
}
