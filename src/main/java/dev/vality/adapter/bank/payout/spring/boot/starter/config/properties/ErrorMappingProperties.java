package dev.vality.adapter.bank.payout.spring.boot.starter.config.properties;

import dev.vality.adapter.common.mapper.SimpleErrorMapping;
import dev.vality.error.mapping.ErrorMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;


@Configuration
public class ErrorMappingProperties {

    @Value("${error-mapping.file}")
    private Resource errorMappingFilePath;

    @Value("${error-mapping.patternReason:\"'%s' - '%s'\"}")
    private String errorMappingPattern;

    @Bean
    public ErrorMapping errorMapping() throws IOException {
        return new SimpleErrorMapping(errorMappingFilePath, errorMappingPattern).createErrorMapping();
    }
}
