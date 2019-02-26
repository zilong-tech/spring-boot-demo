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
@RabbitListener(queues = "topic.message")
@Component
public class Receiver2 {

    @RabbitHandler
    public void recive(String msg){
        System.out.println("Receive2收到消息： " + msg);
    }
}
