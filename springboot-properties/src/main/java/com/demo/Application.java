package com.demo;

import com.demo.property.HomeProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Resource
    private HomeProperties homeProperties;

    public static void main (String [] args){
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n" + homeProperties.toString());
        System.out.println();
    }
}
