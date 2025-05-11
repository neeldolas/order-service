package com.dinegrid.order_service.dto;

import lombok.Data;

@Data
public class MenuItemResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean available;
}
