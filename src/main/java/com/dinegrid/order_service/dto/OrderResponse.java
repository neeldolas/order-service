package com.dinegrid.order_service.dto;

import lombok.Data;

@Data
public class OrderResponse {
    private String orderId;
    private String userId;
    private String menuItemId;
    private int quantity;
    private double totalPrice;
    private String status;
}
