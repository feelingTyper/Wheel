package com.fortune.service.serviceImpl;

import com.fortune.dao.AwardInfoMapper;
import com.fortune.entity.AwardInfo;
import com.fortune.pojo.DataBaseError;
import com.fortune.util.ErrorCodeUtil;
import com.fortune.service.AwardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/8/15.
 */
@Service
public class AwardInfoServiceImpl implements AwardInfoService {

    @Autowired
    AwardInfoMapper awardInfoMapper;
    public int insert(AwardInfo awardInfo) {
        try {
            return awardInfoMapper.insert(awardInfo);
        } catch (Exception e) {
            System.out.println(new DataBaseError(ErrorCodeUtil.FAILED, e.getCause()));
            return ErrorCodeUtil.FAILED;
        }
    }

    public int deleteByAwardId(Integer id) {
        try {
            return awardInfoMapper.deleteByAwardId(id);
        } catch (Exception e) {
            System.out.println(new DataBaseError(ErrorCodeUtil.FAILED, e.getCause()));
            return ErrorCodeUtil.FAILED;
        }
    }

    public int deleteAwardInfoByIdweek(Integer id, Integer week) {
        try {
            return awardInfoMapper.deleteByAwardIdAndWeek(id, week);
        } catch (Exception e) {
            System.out.println(new DataBaseError(ErrorCodeUtil.FAILED, e.getCause()));
            return ErrorCodeUtil.FAILED;
        }
    }

    public int updateByAwardId(AwardInfo awardInfo) {
        try {
            return awardInfoMapper.updateByAwardId(awardInfo);
        } catch (Exception e) {
            System.out.println(new DataBaseError(ErrorCodeUtil.FAILED, e.getCause()));
            return ErrorCodeUtil.FAILED;
        }
    }

    @Deprecated
    public List<AwardInfo> selectAwards() {
        return awardInfoMapper.selectAll();
    }

    public List<AwardInfo> selectAllByWeek(Integer week) {
        return awardInfoMapper.selectAllByWeek(week);
    }

    public AwardInfo selectAwardByIdWeek(Integer id, Integer week) {
        return awardInfoMapper.selectByAwardIdWeek(id, week);
    }

    @Deprecated
    public AwardInfo selectAwardById(Integer id) {
        return awardInfoMapper.selectByAwardId(id);
    }
}
