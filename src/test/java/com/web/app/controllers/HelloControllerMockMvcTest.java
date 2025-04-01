package com.web.app.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
public class HelloControllerMockMvcTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void autowiringWorks() {
        assertNotNull(mvc);
    }

    @Test
    void testHelloControllerWithoutName() throws Exception{
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("user", "hania"));
    }

    @Test
    void testHelloControllerWithName() throws Exception{
        mvc.perform(get("/hello?name={name}","Witek"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("user", "Witek"));
    }
}
