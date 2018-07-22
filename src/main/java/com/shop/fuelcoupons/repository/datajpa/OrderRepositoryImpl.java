package com.shop.fuelcoupons.repository.datajpa;

import com.shop.fuelcoupons.model.Order;
import com.shop.fuelcoupons.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final CrudOrderRepository crudOrderRepository;

    private final CrudUserRepository crudUserRepository;

    @Autowired
    public OrderRepositoryImpl(CrudOrderRepository crudOrderRepository, CrudUserRepository crudUserRepository) {
        this.crudOrderRepository = crudOrderRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    @Transactional("jpaTransactionManager")
    public Order save(Order order, int userId) {
        if (!order.isNew() && get(order.getId(), userId) == null) {
            return null;
        }
        order.setUser(crudUserRepository.getOne(userId));
        return crudOrderRepository.save(order);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudOrderRepository.delete(id, userId) != 0;
    }

    @Override
    public Order get(int id, int userId) {
        return crudOrderRepository.findById(id).filter(order -> order.getUser().getId() == userId).orElse(null);
    }

    @Override
    public List<Order> getAll(int userId) {
        return crudOrderRepository.getAll(userId);
    }

    @Override
    public List<Order> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return crudOrderRepository.getBetween(startDate, endDate, userId);
    }

    @Override
    public Order getWithOrderDetails(int id) {
        return crudOrderRepository.getWithOrderDetails(id);
    }
}
