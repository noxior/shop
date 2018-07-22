package com.shop.fuelcoupons.repository;

import com.shop.fuelcoupons.model.Fuel;

import java.util.List;

public interface FuelRepository {

    List<Fuel> getAll();

    Fuel get(int id);
}
