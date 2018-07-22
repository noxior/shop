package com.shop.fuelcoupons.repository;

import com.shop.fuelcoupons.model.FuelStation;

import java.util.List;

public interface FuelStationRepository {

    List<FuelStation> getAll();

    FuelStation get(int id);
}
