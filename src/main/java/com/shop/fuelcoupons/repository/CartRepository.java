package com.shop.fuelcoupons.repository;

import com.shop.fuelcoupons.model.Cart;

import java.util.List;

public interface CartRepository {
    Cart save(Cart cart, int userId);

    boolean delete(int id, int userId);

    boolean deleteAll(int userId);

    Cart get(int id, int userId);

    List<Cart> getAll(int userId);
}
