package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

import java.util.*;

//只要想添加带参数构造函数, 那么就必须生成一个无参构造
public class UserDaoImpl implements UserDao {
    public UserDaoImpl(){
        System.out.println("UserDaoImpl正在创建....");
    }

    public UserDaoImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    private String name;
    private Integer age;
    private Date birthday;

    private List<String> myList = new ArrayList<String>();
    private Set<String> mySet = new HashSet<String>();
    private String[] myArr;
    private Map<String,String> myMap = new HashMap<String, String>();

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyArr(String[] myArr) {
        this.myArr = myArr;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("对象销毁");
    }

    public void m1(){
        System.out.println("对象创建完毕了");
    }

    public void m2(){
        System.out.println("对象即将销毁");
    }

    public void save() {
        System.out.println("用户保存成功了");
    }

    @Override
    public String toString() {
        return "UserDaoImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myArr=" + Arrays.toString(myArr) +
                ", myMap=" + myMap +
                '}';
    }
}



















