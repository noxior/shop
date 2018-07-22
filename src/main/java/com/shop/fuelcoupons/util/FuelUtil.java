package com.shop.fuelcoupons.util;

import com.shop.fuelcoupons.model.Fuel;
import com.shop.fuelcoupons.model.FuelStation;
import com.shop.fuelcoupons.to.FuelWithFuelStationName;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FuelUtil {

    private FuelUtil() {
    }

    public static List<FuelWithFuelStationName> getWithFuelStation(List<Fuel> fuelList, List<FuelStation> fuelStations) {
        Map<Integer, String> map = fuelStations.stream().collect(Collectors.toMap(FuelStation::getId, FuelStation::getName));
        return fuelList
                .stream()
                .map(fuel -> new FuelWithFuelStationName(fuel.getId(), map.get(fuel.getFuelStationId()), fuel.isEnable(), fuel.getName(), fuel.getPrice()))
                .sorted(Comparator.comparing(FuelWithFuelStationName::getFuelStationName))
                .collect(toList());
    }

    public static FuelWithFuelStationName getWithFuelStation(Fuel fuel, FuelStation fuelStation) {
        return new FuelWithFuelStationName(fuelStation.getName(), fuel.isEnable(), fuel.getName(), fuel.getPrice());
    }
}
