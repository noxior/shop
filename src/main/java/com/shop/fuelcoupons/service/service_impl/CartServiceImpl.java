package com.shop.fuelcoupons.service.service_impl;

import com.shop.fuelcoupons.model.Cart;
import com.shop.fuelcoupons.repository.CartRepository;
import com.shop.fuelcoupons.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.shop.fuelcoupons.util.ValidationUtil.checkNotFoundWithId;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository repository;

    @Autowired
    public CartServiceImpl(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cart get(int id, int userId) {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    @Override
    public void delete(int id, int userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    @Override
    public List<Cart> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public Cart update(Cart cart, int userId) {
        return checkNotFoundWithId(repository.save(cart, userId), cart.getId());
    }

    @Override
    public Cart create(Cart cart, int userId) {
        Assert.notNull(cart, "cart must not be null");
        return repository.save(cart, userId);
    }
}