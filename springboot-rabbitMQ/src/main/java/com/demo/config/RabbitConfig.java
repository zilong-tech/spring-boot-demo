package com.demo.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:声明队列、交换机、绑定关系,也可以在rabbitmq控制台中声明这些关系
 * <p>
 * Create on 2019/02/21
 *
 * @author zouyongsheng
 */
@Configuration
public class RabbitConfig {

    // 队列名称
    public final static String SPRING_BOOT_QUEUE = "spring-boot-queue";
    // 交换机名称
    public final static String SPRING_BOOT_EXCHANGE = "spring-boot-exchange";
    // 绑定的值
    public static final String SPRING_BOOT_BIND_KEY = "spring-boot-bind-key";


    /**
     * 定义队列：
     * @return
     */
    @Bean
    Queue queue() {
        return new Queue(SPRING_BOOT_QUEUE, false);
    }

    /**
     * 定义交换机
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(SPRING_BOOT_EXCHANGE);
    }

    /**
     * 定义绑定
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(SPRING_BOOT_BIND_KEY);
    }

}
