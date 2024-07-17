package dev.vality.adapter.bank.payout.spring.boot.starter.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
@Configuration
@ConfigurationProperties("adapter")
@Validated
public class AdapterProperties {

    @NotEmpty
    private String url;

}
