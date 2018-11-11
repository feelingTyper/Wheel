package com.fortune.service.serviceImpl;

import com.fortune.dao.UserInfoMapper;
import com.fortune.entity.UserInfo;
import com.fortune.service.WheelService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/8/18.
 */
@Service
public class WheelServiceImpl implements WheelService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo insertAndSelect(UserInfo userInfo, String phone) {
        userInfoMapper.insert(userInfo);

        UserInfo user = userInfoMapper.selectByUserPhone(phone);
        return user;
    }
}
