package com.web.app.services;

import com.web.app.json.AstroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class AstroService {
    private final RestTemplate template;

    private final WebClient client;

    public AstroService(RestTemplate tmpl) {
        template=tmpl;
        client = WebClient.create("http://api.open-notify.org");
    }

    public String getPeopleInSpace() {
        return  template.getForObject("/astros.json", String.class);
    }
    public AstroResponse getAstroResponse() {
        return  template.getForObject("/astros.json", AstroResponse.class);
    }

    public AstroResponse getAstroResponseAsync() {
        return  client.get()
                .uri("/astros.json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResponse.class)
                .block(Duration.ofSeconds(2));
    }
}
