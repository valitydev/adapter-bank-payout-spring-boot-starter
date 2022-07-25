package dev.vality.adapter.bank.payout.spring.boot.starter.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vality.adapter.common.component.SimpleObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleObjectMapperConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new SimpleObjectMapper().createSimpleObjectMapperFactory();
    }

}
