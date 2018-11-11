package com.fortune.service;

import com.fortune.entity.UserInfo;

/**
 * Created by admin on 2017/8/18.
 */
public interface WheelService {
    UserInfo insertAndSelect(UserInfo userInfo, String phone);
    //TODO
}
