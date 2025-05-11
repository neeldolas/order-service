package com.dinegrid.order_service.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class UserClient {
    private final RestTemplate restTemplate;

    public boolean userExists(String userId) {
        String url = "http://food-ordering-service:8081/api/v1/auth/user/" + userId;
        return Boolean.TRUE.equals(restTemplate.getForObject(url, Boolean.class));
    }
}
