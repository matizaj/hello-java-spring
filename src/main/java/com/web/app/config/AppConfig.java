package com.web.app.config;

import com.web.app.services.AstroInterface;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate astroRestTemplate(RestTemplateBuilder builder, @Value("${astro.url}") String baseUrl) {
         return builder.rootUri(baseUrl).build();
    }

    @Bean
    public AstroInterface astroInterface(@Value("${astro.url}") String baseUrl) {
        System.out.println(baseUrl);
        WebClient webClient = WebClient.create("http://api.open-notify.org");
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(AstroInterface.class);
    }

}
