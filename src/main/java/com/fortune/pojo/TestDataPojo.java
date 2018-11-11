package com.fortune.pojo;

/**
 * Created by admin on 2017/8/15.
 */
public class TestDataPojo {

    private String userName;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "TestDataPojo{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
