package com.web.app.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AstroService {
    final private RestTemplate template;

    public AstroService(RestTemplateBuilder builder) {
        template=builder.rootUri("http://api.open-notify.org").build();
    }

    public String getPeopleInSpace() {
        return  template.getForObject("/astros.json", String.class);
    }
}
