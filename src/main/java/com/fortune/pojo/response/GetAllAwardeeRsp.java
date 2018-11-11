package com.fortune.pojo.response;


import com.fortune.entity.Awardee;
import com.fortune.pojo.AwardeePojo;

import java.util.List;

/**
 * 获取所有获奖人信息响应实体
 * Created by lichang on 2017/8/16.
 */
public class GetAllAwardeeRsp extends Response {
    private List<AwardeePojo> awardeePojoList;

    public List<AwardeePojo> getAwardeePojoList() {
        return awardeePojoList;
    }

    public void setAwardeePojoList(List<AwardeePojo> awardeePojoList) {
        this.awardeePojoList = awardeePojoList;
    }
}
