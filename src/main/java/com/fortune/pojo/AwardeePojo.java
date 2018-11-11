package com.fortune.pojo;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lichang on 2017/8/14.
 */
@Service
public class AwardeePojo {

    private String userPhone;

    private String awardName;

    private Date date;


    public AwardeePojo() {
        this.userPhone = userPhone;
        this.awardName = awardName;
        this.date = date;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
