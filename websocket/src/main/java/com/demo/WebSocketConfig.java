package com.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Description:开启WebSocket支持
 * <p>
 * Create on 2019/02/26
 *
 * @author zouyongsheng
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //添加一个/chat端点，客户端就可以通过这个端点来进行连接；withSockJS作用是添加SockJS支持
        registry.addEndpoint("/my-websocket").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //定义客户端订阅地址的前缀信息，也就是客户端接收服务端发送消息的前缀信息
        registry.enableSimpleBroker("/queue","/topic");
        //定义了服务端接收地址的前缀，也即客户端给服务端发消息的地址前缀
        registry.setApplicationDestinationPrefixes("/app");
    }

}
