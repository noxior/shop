package ru.javawebinar.topjava.service.datajpa;

import com.shop.fuelcoupons.model.Cart;
import com.shop.fuelcoupons.service.CartService;
import com.shop.fuelcoupons.util.exception.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.service.AbstractServiceTest;

import static ru.javawebinar.topjava.CartTestData.*;
import static ru.javawebinar.topjava.CartTestData.CARTS;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

public class DataJpaCartServiceTest extends AbstractServiceTest {
    @Autowired
    protected CartService service;

    @Test
    public void delete() {
        service.delete(CART1_ID, USER_ID);
        assertMatch(service.getAll(USER_ID), CART2, CART3, CART4, CART5, CART6);
    }

    @Test
    public void deleteNotFound() {
        thrown.expect(NotFoundException.class);
        service.delete(CART1_ID, 1);
    }

    @Test
    public void getNotFound() {
        thrown.expect(NotFoundException.class);
        service.get(CART1_ID, ADMIN_ID);
    }

    @Test
    public void create() {
        Cart created = getCreated();
        service.create(created, USER_ID);
        assertMatch(service.getAll(USER_ID), CART1, CART2, CART3, CART4, CART5, CART6, created);
    }

    @Test
    public void get() {
        Cart actual = service.get(ADMIN_CART_ID, ADMIN_ID);
        assertMatch(actual, ADMIN_CART1);
    }

    @Test
    public void update() {
        Cart updated = getUpdated();
        service.update(updated, USER_ID);
        assertMatch(service.get(CART1_ID, USER_ID), updated);
    }

    @Test
    public void updateNotFound() {
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id=" + CART1_ID);
        service.update(CART1, ADMIN_ID);
    }

    @Test
    public void getAll() throws Exception {
        assertMatch(service.getAll(USER_ID), CARTS);
    }
}
