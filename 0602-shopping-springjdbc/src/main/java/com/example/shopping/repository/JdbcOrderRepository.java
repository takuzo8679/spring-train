package com.example.shopping.repository;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.shopping.entity.Order;

import java.util.Map;

@Repository
public class JdbcOrderRepository implements OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map<String, Object> getById(String id) {
        return jdbcTemplate.queryForMap(
//                "SELECT * FROM t_order JOIN t_order_item ON t_order.id = t_order_item.id  WHERE t_order.id=?",
                "SELECT * FROM t_order WHERE id=?",
//                new DataClassRowMapper<>(Order.class),
                id
            );
    }

    @Override
    public void insert(Order order) {
        jdbcTemplate.update("INSERT INTO t_order values (?, ?, ?, ?, ?, ?, ?, ?)",
                order.getId(),
                order.getOrderDateTime(),
                order.getBillingAmount(),
                order.getCustomerName(),
                order.getCustomerAddress(),
                order.getCustomerPhone(),
                order.getCustomerEmailAddress(),
                order.getPaymentMethod().toString());
    }
}
