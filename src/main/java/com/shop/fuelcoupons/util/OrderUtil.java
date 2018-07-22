package com.shop.fuelcoupons.util;

import com.shop.fuelcoupons.model.Order;
import com.shop.fuelcoupons.model.OrderDetail;
import com.shop.fuelcoupons.to.OrderWithSum;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OrderUtil {

    private OrderUtil() {
    }

    public static List<OrderWithSum> getWithSum(Collection<Order> orders) {
        return getWithSum(orders, LocalTime.MIN, LocalTime.MAX);
    }

    public static List<OrderWithSum> getWithSum(Collection<Order> orders, LocalTime startTime, LocalTime endTime) {
        return orders.stream()
                .map(order -> createWithSum(order, order.getOrderDetails()
                        .stream()
                        .map(OrderDetail::getAmount)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)))
                .collect(Collectors.toList());
    }

    public static OrderWithSum createWithSum(Order order, BigDecimal amountOrder) {
        return new OrderWithSum(order.getId(), order.getDateTime(), amountOrder, order.getStatus());
    }
}