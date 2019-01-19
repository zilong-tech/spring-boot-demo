package com.demo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController：提供实现了REST API，可以服务JSON,XML或者其他。这里是以String的形式渲染出结果。
 */
@RestController
public class HelloWorldController {

    @RequestMapping(value="/")
    public String  sayHello(){
        return "Hello World";
    }
}
