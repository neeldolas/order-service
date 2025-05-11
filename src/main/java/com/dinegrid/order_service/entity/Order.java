package com.dinegrid.order_service.entity;


import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private Long userId;
    private Long menuItemId;
    private Integer quantity;
    private Double totalPrice;
    private String status;
}
