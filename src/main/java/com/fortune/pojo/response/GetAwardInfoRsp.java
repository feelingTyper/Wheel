package com.fortune.pojo.response;

import com.fortune.entity.AwardInfo;
import com.fortune.pojo.AwardInfoPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取奖品信息响应实体
 * Created by lichang on 2017/8/15.
 */
public class GetAwardInfoRsp extends Response {
    private List<AwardInfoPojo> awardInfoPojo;

    public List<AwardInfoPojo> getAwardInfoPojo() {
        return awardInfoPojo;
    }

    public void setAwardInfoPojo(List<AwardInfoPojo> awardInfoPojo) {
        this.awardInfoPojo = awardInfoPojo;
    }
}
