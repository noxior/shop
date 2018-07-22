package com.shop.fuelcoupons.to;

import java.math.BigDecimal;

public class FuelWithFuelStationName extends BaseTo {

    private String fuelStationName;

    private boolean enabled;

    private String fuelName;

    private BigDecimal price;

    public FuelWithFuelStationName() {
    }

    public FuelWithFuelStationName(String fuelStationName, boolean enabled, String fuelName, BigDecimal price) {
        this.fuelStationName = fuelStationName;
        this.enabled = enabled;
        this.fuelName = fuelName;
        this.price = price;
    }

    public FuelWithFuelStationName(Integer id, String fuelStationName, boolean enabled, String fuelName, BigDecimal price) {
        super(id);
        this.fuelStationName = fuelStationName;
        this.enabled = enabled;
        this.fuelName = fuelName;
        this.price = price;
    }

    public String getFuelStationName() {
        return fuelStationName;
    }

    public String getFuelName() {
        return fuelName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return "FuelWithFuelStationName{" +
                "id=" + id +
                ", fuelStationName='" + fuelStationName +
                ", enabled=" + enabled +
                ", fuelName='" + fuelName +
                ", price=" + price +
                '}';
    }
}
