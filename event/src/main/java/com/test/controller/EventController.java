package com.test.controller;

import com.test.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    PublishService publishService;

    @RequestMapping("publishMsg")
    public void publishMsg() {
        for (int i = 0; i < 5; i++) {
            publishService.publish("消息" + (i + 1));
        }
    }
}
