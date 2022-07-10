package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;

    public  void setKey(String key,String value){
        template.opsForValue().set(key,value,1, TimeUnit.MINUTES);//1分钟过期
    }

    public String getValue(String key){
        return this.template.opsForValue().get(key);
    }


    public void setHash(String key,String filed,String value){
        template.opsForHash().put(key,filed,value);
    }

    public Object getHash(String key,String filed){
        return template.opsForHash().get(key, filed);
    }
}