package com.shop.fuelcoupons.service;

import com.shop.fuelcoupons.model.Cart;
import com.shop.fuelcoupons.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface CartService {
    Cart get(int id, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    List<Cart> getAll(int userId);

    Cart update(Cart cart, int userId) throws NotFoundException;

    Cart create(Cart cart, int userId);
}