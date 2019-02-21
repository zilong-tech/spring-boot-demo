package com.demo.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:序列化类RabbitMsgConvertConfigure,当消息类型是实体类时需要
 * <p>
 * Create on 2019/02/21
 *
 * @author zouyongsheng
 */
@Configuration
public class RabbitMsgConvertConfigure {

    @Bean
    MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
