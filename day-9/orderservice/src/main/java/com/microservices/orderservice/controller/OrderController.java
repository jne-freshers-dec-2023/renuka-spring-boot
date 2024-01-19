package com.microservices.orderservice.controller;

import com.microservices.orderservice.dto.OrderRequest;
import com.microservices.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.createorder(orderRequest);
    }
}
