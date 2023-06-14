package com.demo;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.example.jetcachedemo")
public class JetcacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetcacheDemoApplication.class, args);
    }

}
