package com.shop.fuelcoupons.web.fuel;

import com.shop.fuelcoupons.service.FuelService;
import com.shop.fuelcoupons.to.FuelWithFuelStationName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class AbstractFuelController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private FuelService fuelService;

    public List<FuelWithFuelStationName> getAllWithFuelStations(){
        log.info("get getWithFuelStation with fuel stations");
        return fuelService.getAllWithFuelStations();
    }

    public FuelWithFuelStationName get(@PathVariable("id") int id) {
        return fuelService.getWithFuelStation(id);
    }
}
