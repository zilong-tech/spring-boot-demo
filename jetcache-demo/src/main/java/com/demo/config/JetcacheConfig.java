package com.demo.config;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheManager;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.template.QuickConfig;
import com.example.jetcachedemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.Duration;

/**
 * @author benjamin_5
 * @Description 仅方式三需要配置该配置类
 * @date 2023/5/4
 */
@Configuration
public class JetcacheConfig {

    @Autowired
    private CacheManager cacheManager;
    private Cache<Long, Object> userCache;

    @PostConstruct
    public void init(){
        QuickConfig qc = QuickConfig.newBuilder("userCache:")
                .expire(Duration.ofSeconds(3600))
                .cacheType(CacheType.BOTH)
                // 本地缓存更新后，将在所有的节点中删除缓存，以保持强一致性
                .syncLocal(false)
                .build();
        userCache = cacheManager.getOrCreateCache(qc);
    }

    @Bean
    public Cache<Long, Object> getUserCache(){
        return userCache;
    }
}
