package com.demo.hello;

import com.demo.config.RabbitConfigure;
import com.demo.pojo.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Description:
 * <p>
 * Create on 2019/02/21
 *
 * @author zouyongsheng
 */
@Component
public class Sender {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "hello" + new Date();
        amqpTemplate.convertAndSend(RabbitConfigure.SPRING_BOOT_EXCHANGE,RabbitConfigure.SPRING_BOOT_BIND_KEY,context);
    }

    public void sendObject(User user){
        amqpTemplate.convertAndSend(RabbitConfigure.SPRING_BOOT_EXCHANGE,RabbitConfigure.SPRING_BOOT_BIND_KEY,user);
    }
}
