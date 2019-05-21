package com.frosters.config;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class ConfigurationApp {

    @Bean
    public TestRestTemplate restTemplate() {
        return new TestRestTemplate();
    }
}
