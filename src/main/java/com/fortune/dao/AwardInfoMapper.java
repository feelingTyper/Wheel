package com.fortune.dao;

import com.fortune.entity.AwardInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AwardInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardInfo record);

    int insertSelective(AwardInfo record);

    AwardInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardInfo record);

    int updateByPrimaryKey(AwardInfo record);

    int updateByAwardId(AwardInfo record);

    @Deprecated
    AwardInfo selectByAwardId(Integer id);

    @Deprecated
    List<AwardInfo> selectAll();

    int deleteByAwardId(Integer id);

    @Select("select * from awardInfo where awardId=#{awardId} and week=#{week}")
    AwardInfo selectByAwardIdWeek(@Param("awardId") Integer awardId, @Param("week") Integer week);

    int deleteByAwardIdAndWeek(@Param("awardId") Integer awardId, @Param("week") Integer week);

    @Select("select * from awardInfo where week=#{week}")
    List<AwardInfo> selectAllByWeek(@Param("week") Integer week);
}