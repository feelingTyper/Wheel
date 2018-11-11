package com.fortune.service;

import com.fortune.entity.AwardInfo;

import java.util.List;

/**
 * Created by admin on 2017/8/15.
 */
public interface AwardInfoService {

    int insert(AwardInfo awardInfo);

    int deleteByAwardId(Integer id);

    int updateByAwardId(AwardInfo awardInfo);

    List<AwardInfo> selectAwards();

    @Deprecated
    AwardInfo selectAwardById(Integer id);

    int deleteAwardInfoByIdweek(Integer id, Integer week);

    AwardInfo selectAwardByIdWeek(Integer id, Integer week);

    List<AwardInfo> selectAllByWeek(Integer week);
}
