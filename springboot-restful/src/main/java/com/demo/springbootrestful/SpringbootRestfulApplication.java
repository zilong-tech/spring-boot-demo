package com.demo.springbootrestful;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan(value = {"com.demo.springbootrestful.dao"})
public class SpringbootRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfulApplication.class, args);
    }
}
