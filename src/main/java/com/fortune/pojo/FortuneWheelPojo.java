package com.fortune.pojo;

import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/8/14.
 */
@Service
public class FortuneWheelPojo {

    private Integer awardid;

    private String awardname;

    private Integer oppertunity;

    public FortuneWheelPojo() {

    }

    public FortuneWheelPojo(Integer awardid, String awardname, Integer oppertunity) {
        this.awardid = awardid;
        this.awardname = awardname;
        this.oppertunity = oppertunity;
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
        this.awardname = awardname;
    }

    public Integer getOppertunity() {
        return oppertunity;
    }

    public void setOppertunity(Integer oppertunity) {
        this.oppertunity = oppertunity;
    }
}
