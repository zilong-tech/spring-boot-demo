package com.zys.service.impl;

import com.zys.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Description:
 * <p>
 * Create on 2019/02/26
 *
 * @author zouyongsheng
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {


    @Resource
    private JavaMailSender mailSender;

    @Resource
    private TemplateEngine templateEngine;

    @Value("${mail.fromMail.addr}")
    public String from;

    /**
     * 发送简单邮件
     * @param to
     * @param subject
     * @param content
     */
    @Override
    public void sendSimpleMail(String to, String subject, String content) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        try {
            mailSender.send(simpleMailMessage);
            log.info("邮件发送成功");
        } catch (MailException e) {
            log.error("邮件发送失败",e);
        }

    }

    /**
     * 发送HTML邮件
     * @param to
     * @param subject
     * @param content
     */
    @Override
    public void sendHtmlMail(String to, String subject, String content) {

        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
        } catch (MessagingException e) {
            log.error("html邮件发送失败",e);
        }

        mailSender.send(message);
    }

    /**
     * 使用模板发送邮件
     */
    @Override
    public void sendTemplateMail(){

        Context context = new Context();
        context.setVariable("id","006");
        String emailTemplate = templateEngine.process("emailTemplate", context);

        sendHtmlMail("1046823730@qq.com","模板邮件",emailTemplate);

    }
}
