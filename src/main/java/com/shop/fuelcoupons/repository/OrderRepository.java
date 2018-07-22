package com.shop.fuelcoupons.repository;

import com.shop.fuelcoupons.model.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository {

    Order save(Order order, int userId);

    boolean delete(int id, int userId);

    Order get(int id, int userId);

    List<Order> getAll(int userId);

    List<Order> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);

    Order getWithOrderDetails(int id);
}
