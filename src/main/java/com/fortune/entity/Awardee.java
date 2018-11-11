package com.fortune.entity;

import java.util.Date;

public class Awardee {
    private Integer id;

    private Integer userid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userId) {
        this.userid = userId;
    }

    private String phonenumber;

    private String awardname;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getAwardname() {
        return awardname;
    }

    public void setAwardname(String awardname) {
        this.awardname = awardname == null ? null : awardname.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Awardee{" +
                "id=" + id +
                ", phonenumber='" + phonenumber + '\'' +
                ", awardname='" + awardname + '\'' +
                ", time=" + time +
                ", userid=" + userid +
                '}';
    }
}