package com.shop.fuelcoupons.web.fuel;

import com.shop.fuelcoupons.to.FuelWithFuelStationName;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ajax/profile/fuels")
public class FuelController extends AbstractFuelController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FuelWithFuelStationName> getAll() {
        return super.getAllWithFuelStations();
    }

    @Override
    @GetMapping(value = "/{id}")
    public FuelWithFuelStationName get(@PathVariable("id") int id) {
        return super.get(id);
    }
}
