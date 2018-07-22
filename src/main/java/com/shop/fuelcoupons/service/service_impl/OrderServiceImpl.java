package com.shop.fuelcoupons.service.service_impl;

import com.shop.fuelcoupons.model.Order;
import com.shop.fuelcoupons.model.OrderDetail;
import com.shop.fuelcoupons.repository.OrderDetailRepository;
import com.shop.fuelcoupons.repository.OrderRepository;
import com.shop.fuelcoupons.repository.datajpa.CrudCartRepository;
import com.shop.fuelcoupons.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.shop.fuelcoupons.util.ValidationUtil.checkNotFoundWithId;


@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    private final OrderDetailRepository detailRepository;

    private final CrudCartRepository cartRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository, OrderDetailRepository detailRepository, CrudCartRepository cartRepository) {
        this.repository = repository;
        this.detailRepository = detailRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public Order get(int id, int userId) {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    @Override
    public void delete(int id, int userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    @Override
    public List<Order> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        Assert.notNull(startDateTime, "startDateTime must not be null");
        Assert.notNull(endDateTime, "endDateTime  must not be null");
        return repository.getBetween(startDateTime, endDateTime, userId);
    }

    @Override
    public List<Order> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public Order update(Order order, int userId) {
        return checkNotFoundWithId(repository.save(order, userId), order.getId());
    }

    @Override
    public Order create(Order order, int userId) {
        Assert.notNull(order, "order must not be null");
        List<OrderDetail> orderDetails = new ArrayList<>(0);
        cartRepository.getAll(userId)
                .stream()
                .map(cart -> new OrderDetail(cart.getFuelStationName(), cart.getAmount(),
                        cart.getPrice(), cart.getFuelName(), cart.getQuantity()))
                .forEach(orderDetails::add);
        Order savedOrder = repository.save(order, userId);
        cartRepository.deleteAll(userId);
        return savedOrder;
    }
}