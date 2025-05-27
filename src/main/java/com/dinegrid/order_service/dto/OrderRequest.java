package com.dinegrid.order_service.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private String userId;
    private Long menuItemId;
    private int quantity;
}
