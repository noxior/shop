package com.shop.fuelcoupons.repository.jdbc;

import com.shop.fuelcoupons.model.FuelStation;
import com.shop.fuelcoupons.repository.FuelStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FuelStationRepositoryImpl implements FuelStationRepository {

    private static final RowMapper<FuelStation> ROW_MAPPER = BeanPropertyRowMapper.newInstance(FuelStation.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

    private final SimpleJdbcInsert insertFuelStation;

    @Autowired
    public FuelStationRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertFuelStation = new SimpleJdbcInsert(dataSource)
                .withTableName("fuel_stations")
                .usingGeneratedKeyColumns("id");

        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<FuelStation> getAll() {
        return jdbcTemplate.query("SELECT * FROM fuel_stations", ROW_MAPPER);
    }

    @Override
    public FuelStation get(int id) {
        List<FuelStation> fuelStations = jdbcTemplate.query("SELECT * FROM fuel_stations WHERE id = ?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(fuelStations);
    }
}
