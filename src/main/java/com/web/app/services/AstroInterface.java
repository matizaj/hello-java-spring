package com.web.app.services;

import com.web.app.json.AstroResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface AstroInterface {
    @GetExchange("/astros.json")
    AstroResponse getResponse();
}
