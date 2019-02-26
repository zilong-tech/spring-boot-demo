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
@RabbitListener(queues = "fanout.C")
public class Receiver4 {

    @RabbitHandler
    public void receive(String msg){
        System.out.println("Receiver4收到消息： "+msg);
    }
}
