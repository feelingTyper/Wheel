package com.fortune.pojo.request;

/**
 * 用户登录请求体
 * Created by lichang on 2017/8/16.
 */
public class UserLoginReq {
    private String userName;

    private String userPhone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
