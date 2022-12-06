package com.demo.springbootrestful;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan(value = {"com.demo.springbootrestful.dao"})
@EnableRetry
public class SpringbootRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfulApplication.class, args);
    }
}
