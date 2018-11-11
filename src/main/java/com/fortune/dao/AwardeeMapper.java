package com.fortune.dao;

import com.fortune.entity.Awardee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AwardeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Awardee record);

    int insertSelective(Awardee record);

    Awardee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Awardee record);

    int updateByPrimaryKey(Awardee record);

    @Deprecated
    List<Awardee> selectByUserPhone(String phone);

    @Select(("select * from awardee where userId = #{id}"))
    List<Awardee> selectByUserId(@Param("id") Integer id);

    @Select("select * from awardee")
    List<Awardee> selectAll();

    @Delete("delete from awardee")
    int deleteAll();

    @Delete("delete from awardee where userId = #{id}")
    int deleteByUserId(@Param("id") Integer id);


}