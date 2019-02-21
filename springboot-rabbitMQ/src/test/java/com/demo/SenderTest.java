package com.demo;

import com.demo.hello.Sender;
import com.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SenderTest {

    @Resource
    private Sender sender;

    @Test
    public void send() {
        sender.send();
    }

    @Test
    public void sendObject(){
        User user = new User();
        user.setName("朱元璋");
        user.setAge("40");
        sender.sendObject(user);
    }
}