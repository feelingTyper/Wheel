package com.fortune.pojo.response;


import com.fortune.entity.Awardee;

import java.util.List;

/**
 * 获取获奖人信息响应实体
 * Created by lichang on 2017/8/16.
 */
public class GetAwardeeRsp extends Response {
    private List<Awardee> awardeeList;

    public List<Awardee> getAwardeeList() {
        return awardeeList;
    }

    public void setAwardeeList(List<Awardee> awardeeList) {
        this.awardeeList = awardeeList;
    }
}
