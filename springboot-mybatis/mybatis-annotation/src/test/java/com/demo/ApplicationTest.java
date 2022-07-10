package com.demo;

import com.demo.domain.Account;
import com.demo.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {


    @Autowired
    AccountService accountService;



    @Test
    public void test(){

        Account account = accountService.findAccount(1);

        System.out.println(account);
    }
}