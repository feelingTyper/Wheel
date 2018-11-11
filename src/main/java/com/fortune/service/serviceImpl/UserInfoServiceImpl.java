package com.fortune.service.serviceImpl;

import com.fortune.dao.UserInfoMapper;
import com.fortune.entity.UserInfo;
import com.fortune.pojo.DataBaseError;
import com.fortune.util.ErrorCodeUtil;
import com.fortune.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/8/15.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public int insert(UserInfo userInfo) {
        try {
            return userInfoMapper.insert(userInfo);
        } catch (Exception e) {
            System.out.println(new DataBaseError(ErrorCodeUtil.FAILED, e.getCause()));
            return ErrorCodeUtil.FAILED;
        }
    }

    public int deleteUserById(Integer id) {
        try {
            return userInfoMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            System.out.println(new DataBaseError(ErrorCodeUtil.FAILED, e.getCause()));
            return ErrorCodeUtil.FAILED;
        }
    }

    public int deleteUsers() {
        try {
            return userInfoMapper.deleteAll();
        } catch (Exception e) {
            System.out.println(new DataBaseError(ErrorCodeUtil.FAILED, e.getCause()));
            return ErrorCodeUtil.FAILED;
        }
    }

    public UserInfo selectUserByUserId(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Deprecated
    public UserInfo selectUserByPhone(String phoneNumber) {
        return userInfoMapper.selectByUserPhone(phoneNumber);
    }

    public int updateByUserId(UserInfo userInfo) {
        try {
            return userInfoMapper.updateByPrimaryKeySelective(userInfo);
        } catch (Exception e) {
            System.out.println(new DataBaseError(ErrorCodeUtil.FAILED, e.getCause()));
        } finally {
            return ErrorCodeUtil.FAILED;
        }
    }

    public UserInfo selectByUserName(String userName) {
        return userInfoMapper.selectByUserName(userName);
    }

    public UserInfo selectByUserNamePhone(String userName, String userPhone) {
        return userInfoMapper.selectByUserNamePhone(userName, userPhone);
    }
}
