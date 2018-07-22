package com.shop.fuelcoupons.repository.jdbc;

import com.shop.fuelcoupons.model.Cart;
import com.shop.fuelcoupons.model.OrderDetail;
import com.shop.fuelcoupons.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional(value = "dataSourceTransactionManager", readOnly = true)
public class OrderDetaiRepositoryImpl implements OrderDetailRepository {

    private static final RowMapper<OrderDetail> ROW_MAPPER = BeanPropertyRowMapper.newInstance(OrderDetail.class);

    private final JdbcTemplate jdbcTemplate;

    private final SimpleJdbcInsert insertOrderDetail;

    @Autowired
    public OrderDetaiRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.insertOrderDetail = new SimpleJdbcInsert(dataSource)
                .withTableName("order_details")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional("jpaTransactionManager")
    public OrderDetail save(OrderDetail orderDetail, int orderId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", orderDetail.getId())
                .addValue("fuel_station_name", orderDetail.getFuelStationName())
                .addValue("amount", orderDetail.getAmount())
                .addValue("price", orderDetail.getPrice())
                .addValue("fuel_name", orderDetail.getFuelName())
                .addValue("quantity", orderDetail.getQuantity())
                .addValue("order_id", orderId);

        Number newId = insertOrderDetail.executeAndReturnKey(map);
        orderDetail.setId(newId.intValue());

        return orderDetail;
    }

    @Override
    public List<OrderDetail> getAll(int orderId, int userId) {
        return jdbcTemplate.query(
                "SELECT * " +
                        "FROM order_details AS s " +
                        "RIGHT JOIN orders q ON s.order_id =? " +
                        "WHERE q.user_id=? AND q.id =?", ROW_MAPPER, orderId, userId, orderId);
    }
}
