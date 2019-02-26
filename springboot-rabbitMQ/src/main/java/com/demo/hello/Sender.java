package com.demo.hello;

import com.demo.config.RabbitConfigure;
import com.demo.config.TopicRabbitConfig;
import com.demo.pojo.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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

    public void send(int i){
        String context =  i +"";
        amqpTemplate.convertAndSend(RabbitConfigure.SPRING_BOOT_EXCHANGE,RabbitConfigure.SPRING_BOOT_BIND_KEY,context);
    }

    public void sendObject(User user){
        amqpTemplate.convertAndSend(RabbitConfigure.SPRING_BOOT_EXCHANGE,RabbitConfigure.SPRING_BOOT_BIND_KEY,user);
    }

    public void send2(){
        String context = "hi, i am message 1";
        amqpTemplate.convertAndSend("exchange","topic.message",context);
    }

    public void send3(){
        String context = "hi, i am messages 2";
        this.amqpTemplate.convertAndSend("exchange", "topic.messages", context);
    }

    public void send4(){
        String context = "hi, fanout msg ";
        amqpTemplate.convertAndSend("fanoutExchange","", context);
    }

}
