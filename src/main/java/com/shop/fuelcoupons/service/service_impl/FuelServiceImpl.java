package com.shop.fuelcoupons.service.service_impl;

import com.shop.fuelcoupons.model.Fuel;
import com.shop.fuelcoupons.repository.FuelRepository;
import com.shop.fuelcoupons.repository.FuelStationRepository;
import com.shop.fuelcoupons.service.FuelService;
import com.shop.fuelcoupons.to.FuelWithFuelStationName;
import com.shop.fuelcoupons.util.FuelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelServiceImpl implements FuelService {

    private final FuelRepository fuelRepository;

    private final FuelStationRepository stationRepository;

    @Autowired
    public FuelServiceImpl(FuelRepository fuelRepository, FuelStationRepository stationRepository) {
        this.fuelRepository = fuelRepository;
        this.stationRepository = stationRepository;
    }

    @Override
    public List<FuelWithFuelStationName> getAllWithFuelStations() {
        return FuelUtil.getWithFuelStation(fuelRepository.getAll(), stationRepository.getAll());
    }

    @Override
    public FuelWithFuelStationName getWithFuelStation(int id) {
        Fuel fuel = fuelRepository.get(id);
        return FuelUtil.getWithFuelStation(fuel, stationRepository.get(fuel.getFuelStationId()));
    }
}
