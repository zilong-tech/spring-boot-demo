package com.demo.config;

import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * <p>
 * Create on 2019/02/21
 *
 * @author zouyongsheng
 */
@Configuration
public class RabbitConfigure {

    // 队列名称
    public final static String SPRING_BOOT_QUEUE = "spring-boot-queue";
    // 交换机名称
    public final static String SPRING_BOOT_EXCHANGE = "spring-boot-exchange";
    // 绑定的值
    public static final String SPRING_BOOT_BIND_KEY = "spring-boot-bind-key";

}
