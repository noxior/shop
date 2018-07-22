package com.shop.fuelcoupons.repository.datajpa;

import com.shop.fuelcoupons.model.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(value = "jpaTransactionManager", readOnly = true)
public interface CrudOrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Transactional("jpaTransactionManager")
    @Query("DELETE FROM Order m WHERE m.id=:id AND m.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Override
    @Transactional("jpaTransactionManager")
    Order save(Order item);

    @Query("SELECT m FROM Order m WHERE m.user.id=:userId ORDER BY m.dateTime DESC")
    List<Order> getAll(@Param("userId") int userId);

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT m from Order m WHERE m.user.id=:userId AND m.dateTime BETWEEN :startDate AND :endDate ORDER BY m.dateTime DESC")
    List<Order> getBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("userId") int userId);

    @EntityGraph(attributePaths = {"order_details"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT o FROM Order o WHERE o.id=?1")
    Order getWithOrderDetails(int id);
}