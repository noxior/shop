package com.shop.fuelcoupons.repository.datajpa;

import com.shop.fuelcoupons.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(value = "jpaTransactionManager", readOnly = true)
public interface CrudCartRepository extends JpaRepository<Cart, Integer> {

    @Modifying
    @Transactional("jpaTransactionManager")
    @Query("DELETE FROM Cart m WHERE m.id=:id AND m.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Override
    @Transactional("jpaTransactionManager")
    Cart save(Cart item);

    @Query("SELECT m FROM Cart m WHERE m.user.id=:userId")
    List<Cart> getAll(@Param("userId") int userId);

    @Query("DELETE FROM Cart m WHERE m.user.id=:userId")
    boolean deleteAll(@Param("userId") int userId);

    @Override
    Optional<Cart> findById(Integer integer);
}