package com.zys.service.impl;

import com.zys.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {

    @Resource
    private MailService mailService;

    //@org.junit.Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("1046823730@qq.com","simple mail","hello this is simple mail");
    }

    //@Test
    public void sendHtmlMail(){

        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("1046823730@qq.com","html mail",content);
    }

    //@Test
    public void templteMail(){
        mailService.sendTemplateMail();
    }
}