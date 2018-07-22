package com.shop.fuelcoupons.web.user;

import com.shop.fuelcoupons.model.Role;
import com.shop.fuelcoupons.model.User;
import com.shop.fuelcoupons.service.FuelService;
import com.shop.fuelcoupons.service.UserService;
import com.shop.fuelcoupons.to.FuelWithFuelStationName;
import com.shop.fuelcoupons.to.UserTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.shop.fuelcoupons.util.ValidationUtil.assureIdConsistent;

public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private FuelService fuelService;

    public List<FuelWithFuelStationName> getAllFuels() {
        return fuelService.getAllWithFuelStations();
    }

    public List<User> getAllUsers() {
        log.info("getAll");
        return userService.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return userService.get(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        if(!user.isNew())
            throw new IllegalArgumentException(user + " must be new (id=null)");
        Set<Role> role = new HashSet<>();
        role.add(Role.ROLE_USER);
        user.setRoles(role);
        System.out.println(user);
        return userService.create(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        userService.delete(id);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        if (user.isNew()) {
            user.setId(id);
            Set<Role> role = new HashSet<>();
            role.add(Role.ROLE_USER);
            user.setRoles(role);
        } else if (user.getId() != id) {
            throw new IllegalArgumentException(user + " must be with id=" + id);
        }
        userService.update(user);
    }

    public void update(UserTo userTo, int id) {
        log.info("update {} with id={}", userTo, id);
        assureIdConsistent(userTo, id);
        userService.update(userTo);
    }

    public void enable(int id, boolean enabled) {
        log.info((enabled ? "enable " : "disable ") + id);
        userService.enable(id, enabled);
    }
}
