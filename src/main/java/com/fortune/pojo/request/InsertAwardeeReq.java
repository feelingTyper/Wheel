package com.fortune.pojo.request;

import com.fortune.entity.Awardee;

import java.util.Date;

/**
 * 新增获奖人请求实体
 * Created by lichang on 2017/8/15.
 */
public class InsertAwardeeReq {
    private int userId;
    private String phoneNum;
    private String awardName;

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
