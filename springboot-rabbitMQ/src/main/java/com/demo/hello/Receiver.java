package com.demo.hello;

import com.demo.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description: @RabbitListener除了可以作用在方法，也可以作用在类上。在后者的情况下，
 *              需要在处理的方法使用@RabbitHandler。一个类可以配置多个@RabbitHandler
 *              @RabbitListener定义在类表示此类是消息监听者并设置要监听的队列
 *              @RabbitHandler：在类中可以定义多个@RabbitHandler，spring boot会根据不同参数传送到不同方法处理
 * <p>
 * Create on 2019/02/21
 *
 * @author zouyongsheng
 */
@Component
@RabbitListener(queues = "spring-boot-queue")
public class Receiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("收到消息："+ msg);
    }

    @RabbitHandler
    public void reeive(User user){
        System.out.println(user.toString());
    }
}
