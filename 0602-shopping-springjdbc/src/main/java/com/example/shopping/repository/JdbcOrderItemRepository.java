package com.example.shopping.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.shopping.entity.OrderItem;

@Repository
public class JdbcOrderItemRepository implements OrderItemRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcOrderItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(OrderItem orderItem) {
        int ret = jdbcTemplate.update(
                "INSERT INTO t_order_item VALUES (?, ?, ?, ?, ?)",
                    orderItem.getId(),
                    orderItem.getOrderId(),
                    orderItem.getProductId(),
                    orderItem.getPriceAtOrder(),
                    orderItem.getQuantity()
        );
        if (ret == 0) {
            throw new RuntimeException("INSERTに失敗");
        }
    }

//    private void insertOld(OrderItem orderItem) {
//        try (
//                Connection con = dataSource.getConnection();
//                PreparedStatement stmt
//                        = con.prepareStatement("INSERT INTO t_order_item VALUES (?, ?, ?, ?, ?)");
//        ) {
//            stmt.setString(1, orderItem.getId());
//            stmt.setString(2, orderItem.getOrderId());
//            stmt.setString(3, orderItem.getProductId());
//            stmt.setInt(4, orderItem.getPriceAtOrder());
//            stmt.setInt(5, orderItem.getQuantity());
//            stmt.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException("INSERTに失敗", ex);
//        }
//    }
}
