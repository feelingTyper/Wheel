package com.fortune.pojo;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lichang on 2017/8/14.
 */
@Service
public class AwardInfoPojo {

    private Integer awardid;

    private String awardname;

    private String awarddes;

    private Integer awardnum;

    private Double awardprob;

    private String[] awardimg;

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

    public String[] getAwardimg() {
        return awardimg;
    }

    public void setAwardimg(String[] awardimg) {
        this.awardimg = awardimg;
    }
}
