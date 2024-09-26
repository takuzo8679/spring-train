package com.example.shopping.repository;

import com.example.shopping.entity.Order;

import java.util.Map;

public interface OrderRepository {
    Map<String, Object> getById(String id);
    void insert(Order order);
}
