package com.dinegrid.order_service.mapper;

import com.dinegrid.order_service.dto.OrderRequest;
import com.dinegrid.order_service.dto.OrderResponse;
import com.dinegrid.order_service.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {


    Order toEntity(OrderRequest request);

    @Mapping(source = "id", target = "orderId")
    OrderResponse toResponse(Order order);
}
