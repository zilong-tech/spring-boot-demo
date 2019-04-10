package com.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Permission implements Serializable {
    private Integer id;

    private String name;

    private String resourceType;

    private String url;

    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;

    /**
     * 父编号
     */
    private Integer parentId;

    private Integer available;

    /**
     * 父编号列表
     */
    private String parentIds;

    private List<Role> roles;

    private static final long serialVersionUID = 1L;


}