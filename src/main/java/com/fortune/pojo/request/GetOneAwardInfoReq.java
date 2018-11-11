package com.fortune.pojo.request;

/**
 * 获取某一项奖品信息请求实体
 * Created by lichang on 2017/8/16.
 */
public class GetOneAwardInfoReq {
    private int awardId;
    private int week;

    public int getAwardId() {
        return awardId;
    }

    public void setAwardId(int awardId) {
        this.awardId = awardId;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
