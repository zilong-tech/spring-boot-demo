package com.demo.dao;

import com.demo.model.UserRoleQuery;
import com.demo.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleDao {
    int countByExample(UserRoleQuery example);

    int deleteByExample(UserRoleQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleQuery example);

    UserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleQuery example);

    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleQuery example);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}