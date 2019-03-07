package com.demo.dao;

import com.demo.model.RolePermission;
import com.demo.model.RolePermissionQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionDao {
    int countByExample(RolePermissionQuery example);

    int deleteByExample(RolePermissionQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExample(RolePermissionQuery example);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionQuery example);

    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionQuery example);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}