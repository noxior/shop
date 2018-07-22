package com.shop.fuelcoupons.web.order_detail;

import com.shop.fuelcoupons.AuthorizedUser;
import com.shop.fuelcoupons.model.OrderDetail;
import com.shop.fuelcoupons.service.OrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class AbstractOrderDetailController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderDetailService service;

    public List<OrderDetail> getAll(int orderId) {
        int userId = AuthorizedUser.id();
        log.info("getAll for user {}", userId);
        return service.getAll(orderId, userId);
    }
}