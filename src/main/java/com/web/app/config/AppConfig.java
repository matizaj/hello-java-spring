package com.web.app.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate astroRestTemplate(RestTemplateBuilder builder, @Value("${astro.url}") String baseUrl) {
         return builder.rootUri(baseUrl).build();
    }

}
