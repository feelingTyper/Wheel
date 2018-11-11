package com.fortune.pojo.response;

import java.util.List;

/**
 * 奖品表单配置响应实体
 * Created by lichang on 2017/8/16.
 */
public class AwardFormConfigRsp extends Response {
    private int awardId;

    private String awardName;

    private String awardDes;

    private Integer awardNum;

    private double awardProb;

    private List<String> awardImg;

    private int week;

    public int getAwardId() {
        return awardId;
    }

    public void setAwardId(int awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardDes() {
        return awardDes;
    }

    public void setAwardDes(String awardDes) {
        this.awardDes = awardDes;
    }

    public Integer getAwardNum() {
        return awardNum;
    }

    public void setAwardNum(Integer awardNum) {
        this.awardNum = awardNum;
    }

    public double getAwardProb() {
        return awardProb;
    }

    public void setAwardProb(double awardProb) {
        this.awardProb = awardProb;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public List<String> getAwardImg() {
        return awardImg;
    }

    public void setAwardImg(List<String> awardImg) {
        this.awardImg = awardImg;
    }

}
