package com.fortune.pojo.request;

/**
 * 删除奖品请求实体
 * Created by lichang on 2017/8/16.
 */
public class DeleteAwardConfigReq {
    private int week;
    private int awardId;

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getAwardId() {
        return awardId;
    }

    public void setAwardId(int awardId) {
        this.awardId = awardId;
    }
}
