package com.itheima.dao;

public interface AccountDao {

    //减钱
    void diff(String accountName, Float amount);

    //加钱
    void add(String accountName, Float amount);
}
