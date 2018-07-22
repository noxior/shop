package com.shop.fuelcoupons.web.cart;

import com.shop.fuelcoupons.AuthorizedUser;
import com.shop.fuelcoupons.model.Cart;
import com.shop.fuelcoupons.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.shop.fuelcoupons.util.ValidationUtil.assureIdConsistent;
import static com.shop.fuelcoupons.util.ValidationUtil.checkNew;

public abstract class AbstractCartController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CartService service;

    public Cart get(int id) {
        int userId = AuthorizedUser.id();
        log.info("get cart {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = AuthorizedUser.id();
        log.info("delete cart {} for user {}", id, userId);
        service.delete(id, userId);
    }

    public List<Cart> getAll() {
        int userId = AuthorizedUser.id();
        log.info("getAll for user {}", userId);
        return service.getAll(userId);
    }

    public Cart create(Cart cart) {
        int userId = AuthorizedUser.id();
        checkNew(cart);
        log.info("create {} for user {}", cart, userId);
        return service.create(cart, userId);
    }

    public void update(Cart cart, int id) {
        int userId = AuthorizedUser.id();
        assureIdConsistent(cart, id);
        log.info("update {} for user {}", cart, userId);
        service.update(cart, userId);
    }
}