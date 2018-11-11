package com.fortune.service;

import com.fortune.entity.AwardInfo;
import com.fortune.entity.Awardee;
import com.fortune.entity.UserInfo;

import java.util.List;

/**
 * Created by admin on 2017/8/15.
 */
public interface AwardeeService {

    int insert(Awardee awardee);

    List<Awardee> selectByUserPhone(String phone);

    List<Awardee> selectByUserId(Integer id);

    List<Awardee> selectAll();

    int deleteAll();

    int deleteByUserId(Integer id);

    int updateByUserId(Awardee awardee);

}
