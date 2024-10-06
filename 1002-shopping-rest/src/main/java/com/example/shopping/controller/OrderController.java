package com.example.shopping.controller;

import com.example.shopping.entity.Order;
import com.example.shopping.service.OrderMaintenanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderMaintenanceService orderMaintenanceService;
    public OrderController(OrderMaintenanceService orderMaintenanceService) { this.orderMaintenanceService = orderMaintenanceService; }

    @GetMapping
    public List<Order> getOrders(){
        return orderMaintenanceService.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderMaintenanceService.findById(id);
    }
}
