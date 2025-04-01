package com.web.app.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloRestControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    void autowiringWork(@LocalServerPort int port) {
        assertNotNull(template);
        System.out.println(port);
    }

    @Test
    void greetWithoutName() {
        var greeting = template.getForObject("/greet", Greeting.class);
        assertNotNull(greeting);
        assertEquals("Hello Hania", greeting.msg());
    }

    @Test
    void greetWithName() {
        var greeting = template.getForEntity("/greet?name={name}", Greeting.class, "Witek");
        assertAll(
                () -> assertNotNull(greeting),
                () ->assertTrue(greeting.getStatusCode().is2xxSuccessful()),
                () ->assertEquals(MediaType.APPLICATION_JSON, greeting.getHeaders().getContentType()),
                () ->assertEquals("Hello Witek", greeting.getBody().msg())
        );

    }
}