package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 * <p>
 * Create on 2019/03/01
 *
 * @author zouyongsheng
 */
@SpringBootApplication
@MapperScan("com.demo.dao")
public class ShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class);
    }
}
