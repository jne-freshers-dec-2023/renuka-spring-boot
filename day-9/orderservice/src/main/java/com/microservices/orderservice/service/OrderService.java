package com.microservices.orderservice.service;

import com.microservices.orderservice.dto.OrderLineItemsDto;
import com.microservices.orderservice.dto.OrderRequest;
import com.microservices.orderservice.entity.Order;
import com.microservices.orderservice.entity.OrderLinesItems;
import com.microservices.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    public  void createorder(OrderRequest orderRequest){
        System.out.println("inside");
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLinesItems> orderLinesItems= orderRequest.getOrderLineItemsDtosList()
                .stream()
                .map(this::mapToDto)
                .toList();
       order.setOrderLinesItems(orderLinesItems);
        System.out.println("not created");
        System.out.println(order);
        System.out.println(order.getId());
        orderRepository.save(order);
        System.out.println("create");
    }
    private OrderLinesItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLinesItems orderLinesItems=new OrderLinesItems();
        orderLinesItems.setPrice(orderLineItemsDto.getPrice());
        orderLinesItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLinesItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLinesItems;
    }
}
