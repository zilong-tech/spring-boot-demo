package com.demo.dao;

import com.demo.model.UserInfo;
import com.demo.model.UserInfoQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoDao {
    int countByExample(UserInfoQuery example);

    int deleteByExample(UserInfoQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoQuery example);

    UserInfo selectUserInfo(String username);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoQuery example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoQuery example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}