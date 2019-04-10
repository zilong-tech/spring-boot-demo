package com.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Role implements Serializable {
    private Integer id;

    private String role;

    /**
     * 角色描述
     */
    private String description;

    private Integer available;

    private List<UserInfo> userInfos;//一个角色对应多个用户

    private List<Permission> permissions; //角色 -- 权限关系：多对多关系;

    private static final long serialVersionUID = 1L;


}