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

   // @Test
    public void send() {

        for (int i=0;i<100;i++){
            sender.send(i);
        }
    }

    //@Test
    public void sendObject(){
        User user = new User();
        user.setName("朱元璋");
        user.setAge("40");
        sender.sendObject(user);
    }

    //@Test
    public void manyToMany(){
        for(int i=0;i<100;i++){
            sender.send(i);
            sender.send(i);
        }
    }

    @Test
    public void sendMessage(){
//        sender.send2();
//        sender.send3();
        sender.send4();
    }
}