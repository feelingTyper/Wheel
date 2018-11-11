package com.fortune.pojo.response;

import com.fortune.entity.AwardInfo;

/**
 * 转盘响应实体
 * Created by lichang on 2017/8/15.
 */
public class FortuneWheelRsp extends Response{

    private AwardInfo data;//获奖信息

    private int drawNum;//剩余抽奖次数

    private int userId;//用户id

    public AwardInfo getData() {
        return data;
    }

    public void setData(AwardInfo data) {
        this.data = data;
    }

    public int getDrawNum() {
        return drawNum;
    }

    public void setDrawNum(int drawNum) {
        this.drawNum = drawNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
