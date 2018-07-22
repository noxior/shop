package com.shop.fuelcoupons.repository.datajpa;

import com.shop.fuelcoupons.model.Cart;
import com.shop.fuelcoupons.repository.CartRepository;
import com.shop.fuelcoupons.repository.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepositoryImpl implements CartRepository {

    private final CrudCartRepository crudCartRepository;

    private final CrudUserRepository crudUserRepository;

    private final FuelRepository fuelRepository;

    @Autowired
    public CartRepositoryImpl(CrudCartRepository crudCartRepository, CrudUserRepository crudUserRepository, FuelRepository fuelRepository) {
        this.crudCartRepository = crudCartRepository;
        this.crudUserRepository = crudUserRepository;
        this.fuelRepository = fuelRepository;
    }

    @Override
    public Cart save(Cart cart, int userId) {
        if (!cart.isNew() && get(cart.getId(), userId) == null) {
            return null;
        }
        cart.setUser(crudUserRepository.findById(userId).get());
        return crudCartRepository.save(cart);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudCartRepository.delete(id, userId) != 0;
    }

    @Override
    public Cart get(int id, int userId) {
        return crudCartRepository.findById(id).filter(cart -> cart.getUser().getId() == userId).orElse(null);
    }

    @Override
    public List<Cart> getAll(int userId) {
        return crudCartRepository.getAll(userId);
    }

    @Override
    public boolean deleteAll(int userId) {
        return crudCartRepository.deleteAll(userId);
    }
}
