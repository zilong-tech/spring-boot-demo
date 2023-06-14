package com.demo.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;
import com.example.jetcachedemo.config.JetcacheConfig;
import com.example.jetcachedemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/5/4
 */
@RestController
@RequestMapping("user3")
public class User3Controller {

    @Autowired
    JetcacheConfig jetcacheConfig;
    @Autowired
    private Cache<Long, Object> userCache;

    @GetMapping("get")
    public User get(Long id){
        if(userCache.get(id) != null){
            return (User) userCache.get(id);
        }
        User user = new User();
        user.setId(id);
        user.setName("用户both"+id);
        user.setAge(23);
        user.setSex(1);
        userCache.put(id, user);
        System.out.println("第一次获取数据，未走缓存："+id);
        return user;
    }

    @PostMapping("updateUser")
    public Boolean updateUser(@RequestBody User user){
        // TODO 更新数据库
        userCache.put(user.getId(), user);
        return true;
    }

    @PostMapping("deleteUser")
    public Boolean deleteUser(Long id){
        // TODO 从数据库删除
        userCache.remove(id);
        return true;
    }

}
