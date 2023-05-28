package com.demo.web;


import com.demo.web.java.MyThread;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  Application很简单，一个main函数作为主入口。SpringApplication引导应用，
 *  并将Application本身作为参数传递给run方法。
 *  具体run方法会启动嵌入式的Tomcat并初始化Spring环境及其各Spring组件。
 *  application.java文件的包必须是项目下的父路径，其他类的包路径必须是其子路径
 */
@SpringBootApplication
public class Application {

    public static void main(String [] args){

        SpringApplication.run(Application.class,args);
    }
}
