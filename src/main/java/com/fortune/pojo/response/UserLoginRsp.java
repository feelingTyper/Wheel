package com.fortune.pojo.response;

/**
 * 用户登录响应体
 * Created by lichang on 2017/8/16.
 */
public class UserLoginRsp extends Response {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
