package com.web.app.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroServiceTest {
    @Autowired
    private AstroService svc;

    @Test
    void getPeopleInSpace() {
        var people = svc.getPeopleInSpace();
        assertTrue(people.contains("people"));
        System.out.println(people);
    }
}