package com.web.app.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import java.util.Collection;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    class User implements Model {

        @Override
        public Model addAttribute(String attributeName, Object attributeValue) {
            return null;
        }

        @Override
        public Model addAttribute(Object attributeValue) {
            return null;
        }

        @Override
        public Model addAllAttributes(Collection<?> attributeValues) {
            return null;
        }

        @Override
        public Model addAllAttributes(Map<String, ?> attributes) {
            return null;
        }

        @Override
        public Model mergeAttributes(Map<String, ?> attributes) {
            return null;
        }

        @Override
        public boolean containsAttribute(String attributeName) {
            return false;
        }

        @Override
        public Object getAttribute(String attributeName) {
            return null;
        }

        @Override
        public Map<String, Object> asMap() {
            return null;
        }
    }
    @Test
    void sayHello() {
        var controller = new HomeController();
        Model model = new BindingAwareModelMap();
        model.addAttribute("user", "matt");
        var result = controller.sayHello("matt", model);
        assertAll(
                ()->assertEquals("matt", model.getAttribute("user")),
                ()->assertEquals("hello",result)
        );
    }
}