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
@Component
@RabbitListener(queues = "topic.messages")
public class Receiver3 {

    @RabbitHandler
    public void receive(String msg){
        System.out.println("Receiver3收到消息： "+ msg);
    }
}
