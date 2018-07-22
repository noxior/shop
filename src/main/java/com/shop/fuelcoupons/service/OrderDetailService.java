package com.shop.fuelcoupons.service;

import com.shop.fuelcoupons.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetail> getAll(int orderId, int userId);
}