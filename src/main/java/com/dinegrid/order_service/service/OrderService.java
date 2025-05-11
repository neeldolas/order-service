package com.dinegrid.order_service.service;

import com.dinegrid.order_service.dto.OrderRequest;
import com.dinegrid.order_service.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);

    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(String id);

    void deleteOrder(String id);
}
