package com.shop.fuelcoupons.service;

import com.shop.fuelcoupons.model.User;
import com.shop.fuelcoupons.to.UserTo;
import com.shop.fuelcoupons.util.exception.NotFoundException;

import java.util.List;

public interface UserService {
    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(User user)throws NotFoundException;

    void update(UserTo user);

    List<User> getAll();

    void enable(int id, boolean enable);
}
