package com.fortune.service;

import com.fortune.entity.UserInfo;

/**
 * Created by admin on 2017/8/15.
 */
public interface UserInfoService {

    int insert(UserInfo userInfo);

    UserInfo selectUserByPhone(String phoneNumber);

    UserInfo selectUserByUserId(Integer id);

    int deleteUserById(Integer id);

    int deleteUsers();

    int updateByUserId(UserInfo userInfo);

    UserInfo selectByUserName(String userName);

    UserInfo selectByUserNamePhone(String userName, String userPhone);
}
