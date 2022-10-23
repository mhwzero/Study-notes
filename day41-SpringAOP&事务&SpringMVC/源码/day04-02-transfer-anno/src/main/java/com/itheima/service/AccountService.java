package com.itheima.service;

public interface AccountService {

    //转账
    void transfer(String accountName, String targetName, Float amount);
}
