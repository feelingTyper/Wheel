package com.fortune.entity;

public class AwardInfo {
    private Integer id;

    private Integer awardid;

    private String awardname;

    private String awarddes;

    private Integer awardnum;

    private Double awardprob;

    private String awardimg;

    private Integer week;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAwardid() {
        return awardid;
    }

    public void setAwardid(Integer awardid) {
        this.awardid = awardid;
    }

    public String getAwardname() {
        return awardname;
    }

    public void setAwardname(String awardname) {
        this.awardname = awardname == null ? null : awardname.trim();
    }

    public String getAwarddes() {
        return awarddes;
    }

    public void setAwarddes(String awarddes) {
        this.awarddes = awarddes == null ? null : awarddes.trim();
    }

    public Integer getAwardnum() {
        return awardnum;
    }

    public void setAwardnum(Integer awardnum) {
        this.awardnum = awardnum;
    }

    public Double getAwardprob() {
        return awardprob;
    }

    public void setAwardprob(Double awardprob) {
        this.awardprob = awardprob;
    }

    public String getAwardimg() {
        return awardimg;
    }

    public void setAwardimg(String awardimg) {
        this.awardimg = awardimg == null ? null : awardimg.trim();
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "AwardInfo{" +
                "id=" + id +
                ", awardid=" + awardid +
                ", awardname='" + awardname + '\'' +
                ", awarddes='" + awarddes + '\'' +
                ", awardnum=" + awardnum +
                ", awardprob=" + awardprob +
                ", awardimg='" + awardimg + '\'' +
                ", week=" + week +
                '}';
    }
}