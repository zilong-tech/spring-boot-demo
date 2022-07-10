package com.demo;


import com.demo.domain.User;
import com.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {


    @Autowired
    UserService userService;



    @Test
    public void test(){

        User user = userService.getUser(1L);
        System.out.println(user);
    }
}