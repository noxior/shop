package com.shop.fuelcoupons.service.service_impl;

import com.shop.fuelcoupons.model.User;
import com.shop.fuelcoupons.repository.UserRepository;
import com.shop.fuelcoupons.service.UserService;
import com.shop.fuelcoupons.to.UserTo;
import com.shop.fuelcoupons.util.UserUtil;
import com.shop.fuelcoupons.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static com.shop.fuelcoupons.util.ValidationUtil.checkNotFound;
import static com.shop.fuelcoupons.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void update(UserTo userTo) {
        User user = get(userTo.getId());
        userRepository.save(UserUtil.updateFromTo(user, userTo));
    }

    @Override
    public User create(User user) {
        //Убедитесь, что объект отсутствует null.
        Assert.notNull(user,"user must not be null");
        //кодируем пароль
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(userRepository.delete(id),id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(userRepository.get(id),id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Assert.notNull(email,"email must not be null");
        return checkNotFound(userRepository.getByEmail(email),"email= "+email);
    }

    @Override
    public void update(User user) throws NotFoundException {
        Assert.notNull(user,"user must not be null");
        //кодируем пароль
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        checkNotFoundWithId(userRepository.save(user),user.getId());
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void enable(int id, boolean enable) {
        User user = get(id);
        user.setEnabled(enable);
        userRepository.save(user);
    }
}
