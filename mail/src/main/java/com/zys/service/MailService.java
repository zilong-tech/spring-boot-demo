package com.zys.service;

/**
 * Description:
 * <p>
 * Create on 2019/02/26
 *
 * @author zouyongsheng
 */
public interface MailService {

    public void sendSimpleMail(String to, String subject, String content);

    void sendHtmlMail(String to, String subject, String content);

    public void sendTemplateMail();
}
