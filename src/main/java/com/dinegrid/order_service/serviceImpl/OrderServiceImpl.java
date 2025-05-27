package com.dinegrid.order_service.serviceImpl;

import com.dinegrid.order_service.client.MenuClient;
import com.dinegrid.order_service.client.UserClient;
import com.dinegrid.order_service.dto.MenuItemResponse;
import com.dinegrid.order_service.dto.OrderRequest;
import com.dinegrid.order_service.dto.OrderResponse;
import com.dinegrid.order_service.entity.Order;
import com.dinegrid.order_service.mapper.OrderMapper;
import com.dinegrid.order_service.repository.OrderRepository;
import com.dinegrid.order_service.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final MenuClient menuClient;

    private final UserClient userClient;

    private final OrderEventProducer orderEventProducer;

    @Override
    public OrderResponse placeOrder(OrderRequest request) {
        log.info("Placing order: {}", request);

//        if (!userClient.userExists(request.getUserId())) {
//            throw new RuntimeException("User not found");
//        }

        MenuItemResponse item = menuClient.getMenuItem(request.getMenuItemId());

        if (item == null || !item.getAvailable()) {
            throw new RuntimeException("Menu Item not available");
        }
        Double price = item.getPrice();
        if (price == null) throw new RuntimeException("Menu Item not found");

        Order order = orderMapper.toEntity(request);
        order.setTotalPrice(price * request.getQuantity());
        order.setStatus("PLACED");

        order = orderRepository.save(order);

        orderEventProducer.publishOrderPlacedEvent(order);

        return orderMapper.toResponse(order);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getOrderById(String id) {
        return orderRepository.findById(id)
                .map(orderMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}
