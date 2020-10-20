package com.covid19.tracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class ApplicationBeanConfig {

    @Autowired
    private ApplicationProperties properties;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .defaultHeader(properties.getRapidApiHostHeader(), properties.getRapidApiHost())
                .defaultHeader(properties.getRapidApiKeyHeader(), properties.getRapidApiKey())
                .build();
    }
}
