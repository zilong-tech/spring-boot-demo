package com.demo.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 * <p>
 * Create on 2019/02/26
 *
 * @author zouyongsheng
 */
@RabbitListener(queues = "spring-boot-queue")
@Component
public class Receiver1 {

    @RabbitHandler
    public void process(String msg){
        System.out.println("Receiver1收到消息："+ msg);
    }
}
