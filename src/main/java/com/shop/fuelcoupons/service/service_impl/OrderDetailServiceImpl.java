package com.shop.fuelcoupons.service.service_impl;

import com.shop.fuelcoupons.model.OrderDetail;
import com.shop.fuelcoupons.repository.OrderDetailRepository;
import com.shop.fuelcoupons.repository.OrderRepository;
import com.shop.fuelcoupons.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository detailRepository;
    ;

    private final OrderRepository repository;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository detailRepository, OrderRepository repository) {
        this.detailRepository = detailRepository;
        this.repository = repository;
    }

    @Override
    public List<OrderDetail> getAll(int orderId, int userId) {
        return detailRepository.getAll(orderId, userId);
    }
}