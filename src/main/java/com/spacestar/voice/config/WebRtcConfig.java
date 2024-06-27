package com.spacestar.voice.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
    public class WebRtcConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        registry.setApplicationDestinationPrefixes("/pub"); // send url 설정
        registry.enableSimpleBroker("/sub"); //broker url 설정
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        // 소켓연결을 위한 endpoint
        registry.addEndpoint("/signaling") // websocket 접속시 endpoint 설정
                .setAllowedOriginPatterns("*") //cors 허용
                .withSockJS(); // 브라우저에서 WebSocket을 지원하지 않을때 대체방법으로 SockJS 사용
        registry.addEndpoint("/signaling") // websocket 접속시 endpoint 설정
                .setAllowedOriginPatterns("*") //cors 허용
                .withSockJS(); // 브라우저에서 WebSocket을 지원하지 않을때 대체방법으로 SockJS 사용
    }
}