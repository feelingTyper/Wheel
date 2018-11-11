package com.fortune.dao;

import com.fortune.entity.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    @Select("select * from userInfo where phoneNumber = #{phone}")
    UserInfo selectByUserPhone(@Param("phone") String phone);

    @Delete("delete from userInfo")
    int deleteAll();

    @Select("select * from userInfo where userName = #{userName}")
    UserInfo selectByUserName(@Param("userName") String userName);

    @Select("select * from userInfo where userName = #{userName} and phoneNumber = #{userPhone}")
    UserInfo selectByUserNamePhone(@Param("userName") String userName, @Param("userPhone") String userPhone);
}