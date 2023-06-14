package com.demo;

import com.demo.domain.User;
import com.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Description:
 * <p>
 * Create on 2023/06/13
 *
 * @author zys
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void test(){

        User user = new User();
        user.setUserName("20230613");
        userService.saveUser(user);
    }
}
