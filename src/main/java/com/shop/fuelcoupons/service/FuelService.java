package com.shop.fuelcoupons.service;

import com.shop.fuelcoupons.to.FuelWithFuelStationName;

import java.util.List;

public interface FuelService {

    List<FuelWithFuelStationName> getAllWithFuelStations();

    FuelWithFuelStationName getWithFuelStation(int id);
}
