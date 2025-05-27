package com.dinegrid.order_service.client;

import com.dinegrid.order_service.dto.MenuItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class MenuClient {
    private final RestTemplate restTemplate;

    public MenuItemResponse getMenuItem(long menuItemId) {
      String url = "http://menu-service:8082/api/v1/menu/" + menuItemId;
//        String url = "http://host.docker.internal:8082/api/v1/menu/" + menuItemId;
        return restTemplate.getForObject(url, MenuItemResponse.class);
    }
}
