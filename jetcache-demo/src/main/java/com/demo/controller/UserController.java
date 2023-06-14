package com.demo.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.*;
import com.example.jetcachedemo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/5/3
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("getRemote")
    @Cached(name="userCache:", key = "#id", expire = 3600, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.REMOTE)
    public User getRemote(Long id){
        // 直接新建用户，模拟从数据库获取数据
        User user = new User();
        user.setId(id);
        user.setName("用户remote"+id);
        user.setAge(23);
        user.setSex(1);
        System.out.println("第一次获取数据，未走缓存："+id);
        return user;
    }

    @GetMapping("getLocal")
    @Cached(name="userCache:", key = "#id", expire = 3600, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.LOCAL)
    public User getLocal(Long id){
        // 直接新建用户，模拟从数据库获取数据
        User user = new User();
        user.setId(id);
        user.setName("用户local"+id);
        user.setAge(23);
        user.setSex(1);
        System.out.println("第一次获取数据，未走缓存："+id);
        return user;
    }

    @GetMapping("getBoth")
    @Cached(name="userCache:", key = "#id", expire = 3600, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.BOTH)
    public User getBoth(Long id){
        // 直接新建用户，模拟从数据库获取数据
        User user = new User();
        user.setId(id);
        user.setName("用户both"+id);
        user.setAge(23);
        user.setSex(1);
        System.out.println("第一次获取数据，未走缓存："+id);
        return user;
    }

    @PostMapping("updateUser")
    @CacheUpdate(name = "userCache:", key = "#user.id", value = "#user")
    public Boolean updateUser(@RequestBody User user){
        // TODO 更新数据库
        return true;
    }

    @PostMapping("deleteUser")
    @CacheInvalidate(name = "userCache:", key = "#id")
    public Boolean deleteUser(Long id){
        // TODO 从数据库删除
        return true;
    }

}
