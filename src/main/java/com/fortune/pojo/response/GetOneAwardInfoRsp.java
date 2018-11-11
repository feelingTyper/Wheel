package com.fortune.pojo.response;

import com.fortune.entity.AwardInfo;
import com.fortune.pojo.AwardInfoPojo;

import java.util.List;

/**
 * 获取某一项奖品信息响应实体
 * Created by lichang on 2017/8/15.
 */
public class GetOneAwardInfoRsp extends Response {
    private AwardInfoPojo awardInfoPojo;

    public AwardInfoPojo getAwardInfoPojo() {
        return awardInfoPojo;
    }

    public void setAwardInfoPojo(AwardInfoPojo awardInfoPojo) {
        this.awardInfoPojo = awardInfoPojo;
    }
}
