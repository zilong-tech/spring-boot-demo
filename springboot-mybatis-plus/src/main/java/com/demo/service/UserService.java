package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.domain.User;

/**
 * Description:
 * <p>
 * Create on 2023/06/13
 *
 * @author zys
 */
public interface UserService  extends  IService<User>{


    public void saveUser(User user);
}
