package com.covid19.tracker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("app")
public class ApplicationProperties {
    public static final String CRON_EXPRESSION = "0 15 10 15 * ?";
    private String rapidApiUrl;
    private String rapidApiHost;
    private String rapidApiHostHeader;
    private String rapidApiKeyHeader;
    private String rapidApiKey;
}
