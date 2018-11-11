package com.fortune.service.serviceImpl;

import com.fortune.dao.AwardeeMapper;
import com.fortune.entity.Awardee;
import com.fortune.pojo.DataBaseError;
import com.fortune.util.ErrorCodeUtil;
import com.fortune.service.AwardeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/8/15.
 */
@Service
public class AwardeeServiceImpl implements AwardeeService {

    @Autowired
    AwardeeMapper awardeeMapper;

    public int insert(Awardee awardee) {
        try {
            return awardeeMapper.insert(awardee);
        } catch (Exception e) {
            System.out.println(new DataBaseError(ErrorCodeUtil.FAILED, e.getCause()));
            return ErrorCodeUtil.FAILED;
        }
    }

    public List<Awardee> selectAll() {
        return awardeeMapper.selectAll();
    }

    @Deprecated
    public List<Awardee> selectByUserPhone(String phone) {
        return awardeeMapper.selectByUserPhone(phone);
    }

    public int deleteAll() {
        try {
            return awardeeMapper.deleteAll();
        } catch (Exception e) {
            System.out.println(new DataBaseError(ErrorCodeUtil.FAILED, e.getCause()));
            return ErrorCodeUtil.FAILED;
        }
    }

    public int deleteByUserId(Integer id) {
        try {
            return awardeeMapper.deleteByUserId(id);
        } catch (Exception e) {
            System.out.println(new DataBaseError(ErrorCodeUtil.FAILED, e.getCause()));
            return ErrorCodeUtil.FAILED;
        }
    }

    public List<Awardee> selectByUserId(Integer id) {
        return awardeeMapper.selectByUserId(id);
    }

    public int updateByUserId(Awardee awardee) {
        try {
            return awardeeMapper.updateByPrimaryKeySelective(awardee);
        } catch (Exception e) {
            System.out.println(new DataBaseError(ErrorCodeUtil.FAILED, e.getCause()));
            return ErrorCodeUtil.FAILED;
        }
    }
}
