package com.shop.fuelcoupons.repository;

import com.shop.fuelcoupons.model.OrderDetail;

import java.util.List;

public interface OrderDetailRepository {

    OrderDetail save(OrderDetail orderDetail, int orderId);

//    boolean delete(int id, int orderId);
//
//    OrderDetail get(int id, int orderId);

    List<OrderDetail> getAll(int orderId, int userId);
}
