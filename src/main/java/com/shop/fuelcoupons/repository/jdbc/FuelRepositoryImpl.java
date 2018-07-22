package com.shop.fuelcoupons.repository.jdbc;

import com.shop.fuelcoupons.model.Fuel;
import com.shop.fuelcoupons.repository.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuelRepositoryImpl implements FuelRepository {

    private static final RowMapper<Fuel> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Fuel.class);


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FuelRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Fuel> getAll() {
        return jdbcTemplate.query("SELECT * FROM fuels", ROW_MAPPER);
    }

    @Override
    public Fuel get(int id) {
        List<Fuel> fuels = jdbcTemplate.query("SELECT * FROM fuels WHERE id = ?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(fuels);
    }
}
