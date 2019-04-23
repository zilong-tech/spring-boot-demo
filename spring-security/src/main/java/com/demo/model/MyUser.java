package com.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * <p>
 * Create on 2019/04/19
 *
 * @author zys
 */
@Data
public class MyUser implements Serializable {

    private static final long serialVersionUID = 3497935890426858541L;
    private String userName;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;
}
