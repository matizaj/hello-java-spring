package com.web.app.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroInterfaceTest {
    @Autowired
    private AstroInterface astroInterface;
    @Test
    void getResponse() {

        var response = astroInterface.getResponse();
        assertNotNull(response);
        assertEquals("success", response.message());
        assertTrue(response.number()>0);
    }
}