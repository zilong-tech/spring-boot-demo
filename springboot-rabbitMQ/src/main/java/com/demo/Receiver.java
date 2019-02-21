package com.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 * <p>
 * Create on 2019/02/21
 *
 * @author zouyongsheng
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("收到消息："+ msg);
    }
}
