package com.fortune.pojo.request;

/**
 * 转盘请求实体
 * Created by lichang on 2017/8/15.
 */
public class FortuneWheelReq {
    private int userId;
    private Integer awardNum;

    public Integer getAwardNum() {
        return awardNum;
    }

    public void setAwardNum(Integer awardNum) {
        this.awardNum = awardNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
