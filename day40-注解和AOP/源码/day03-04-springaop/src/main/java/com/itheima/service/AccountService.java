package com.itheima.service;

import java.util.List;

public interface AccountService {

    void save(Object obj);

    List findAll();

    Object findByAid(Integer aid);

}
