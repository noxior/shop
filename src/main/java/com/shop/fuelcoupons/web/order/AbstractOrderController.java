package com.shop.fuelcoupons.web.order;

import com.shop.fuelcoupons.AuthorizedUser;
import com.shop.fuelcoupons.model.Order;
import com.shop.fuelcoupons.service.OrderService;
import com.shop.fuelcoupons.to.OrderWithSum;
import com.shop.fuelcoupons.util.OrderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.shop.fuelcoupons.util.ValidationUtil.assureIdConsistent;

public abstract class AbstractOrderController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderService service;

    public Order get(int id) {
        int userId = AuthorizedUser.id();
        log.info("get order {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = AuthorizedUser.id();
        log.info("delete order {} for user {}", id, userId);
        service.delete(id, userId);
    }

    public List<OrderWithSum> getAll() {
        int userId = AuthorizedUser.id();
        log.info("getAll for user {}", userId);
        return OrderUtil.getWithSum(service.getAll(userId));
    }

    public Order create(Order order) {
        int userId = AuthorizedUser.id();
        log.info("create {} for user {}", userId);
        return service.create(order, userId);
    }

    public void update(Order order, int id) {
        int userId = AuthorizedUser.id();
        assureIdConsistent(order, id);
        log.info("update {} for user {}", order, userId);
        service.update(order, userId);
    }
}