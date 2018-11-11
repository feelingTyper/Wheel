package com.fortune.controller;

import com.fortune.entity.UserInfo;
import com.fortune.pojo.request.UserLoginReq;
import com.fortune.pojo.request.UserRegistReq;
import com.fortune.pojo.response.UserLoginRsp;
import com.fortune.pojo.response.UserRegistRsp;
import com.fortune.service.UserInfoService;
import com.fortune.util.FortuneWheelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lichang on 2017/8/11.
 */
@Controller

public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户登录
     * @param userLoginReq 用户登录请求体
     * @return
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public UserLoginRsp userLogin (UserLoginReq userLoginReq){
        UserLoginRsp rsp = new UserLoginRsp();
        UserInfo userInfo = userInfoService.selectByUserNamePhone(userLoginReq.getUserName(), userLoginReq.getUserPhone());
        if (userInfo == null){
            rsp.setCode(FortuneWheelUtil.CODE_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_ERROR);
            return rsp;
        }
        rsp.setUserId(userInfo.getId());
        rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
        rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        return rsp;
    }

    /**
     * 用户注册
     * @param userRegistReq 用户登录请求体
     * @return
     */
    @RequestMapping(value = "/userRegist", method = RequestMethod.POST)
    @ResponseBody
    public UserRegistRsp userRegist (UserRegistReq userRegistReq){
        UserRegistRsp rsp = new UserRegistRsp();
        //检查电话号码是否重复
        UserInfo userInfoPhone = userInfoService.selectUserByPhone(userRegistReq.getUserPhone());
        if (userInfoPhone != null){
            rsp.setCode(FortuneWheelUtil.CODE_USERPHONE_EXIST_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_USERPHONE_EXIST_ERROR);
            return rsp;
        }
        //检查用户名是否重复
        UserInfo userInfoName = userInfoService.selectByUserName(userRegistReq.getUserName());
        if (userInfoName != null){
            rsp.setCode(FortuneWheelUtil.CODE_USERNAME_EXIST_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_USERNAME_EXIST_ERROR);
            return rsp;
        }
        //注册信息插入
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(userRegistReq.getUserName());
        userInfo.setPhonenumber(userRegistReq.getUserPhone());
        //既定方案抽奖次数不存储，若存储请执行下面函数
//        userInfo.setOpportunity(FortuneWheelUtil.AWARD_OPPORTUNITY);
        int result = userInfoService.insert(userInfo);
        if (result == -1){
            rsp.setCode(FortuneWheelUtil.CODE_ERROR);
            rsp.setMsg(FortuneWheelUtil.MSG_ERROR);
        }else {
            rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
            rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        }
        rsp.setCode(FortuneWheelUtil.CODE_SUCCESS);
        rsp.setMsg(FortuneWheelUtil.MSG_SUCCESS);
        return rsp;
    }

}
