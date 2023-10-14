package com.demo.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.mybatis.mappers")
public class MybatisTypehandlerEncryptApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisTypehandlerEncryptApplication.class, args);
    }

}
