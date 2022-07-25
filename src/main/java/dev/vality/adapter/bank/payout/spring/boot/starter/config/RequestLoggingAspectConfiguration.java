package dev.vality.adapter.bank.payout.spring.boot.starter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestLoggingAspectConfiguration {

    @Bean
    public RequestLoggingAspect requestLoggingAspect() {
        return new RequestLoggingAspect();
    }
}
