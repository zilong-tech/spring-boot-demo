package com.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class UserInfo implements Serializable {
    private Integer id;

    private String username;

    private String name;

    private String password;

    private List<Role> roleList; //一个用户具有多个角色

    /**
     * 加密密码的盐
     */
    private String salt;

    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */

    /**
     * 密码盐 重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }

    private Integer state;

    private static final long serialVersionUID = 1L;


}