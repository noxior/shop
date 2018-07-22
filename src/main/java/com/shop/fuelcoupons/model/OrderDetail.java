package com.shop.fuelcoupons.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_details")
public class OrderDetail extends AbstractBaseEntity {

    @Column(name = "fuel_station_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String fuelStationName;

    @Column(name = "amount", nullable = false)
    @NotNull
    @Digits(integer=20, fraction=2)
    private BigDecimal amount;

    @Column(name = "price", nullable = false)
    @NotNull
    @Digits(integer=20, fraction=2)
    private BigDecimal price;

    @Column(name = "fuel_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String fuelName;

    @Column(name = "quantity", nullable = false)
    @Range(min = 10, max = 5000)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Order order;

    public OrderDetail(String fuelStationName, BigDecimal amount, BigDecimal price, String fuelName, int quantity) {
        this(null, fuelStationName, amount, price, fuelName, quantity);
    }

    public OrderDetail(Integer id, String fuelStationName, BigDecimal amount, BigDecimal price, String fuelName, int quantity) {
        super(id);
        this.fuelStationName = fuelStationName;
        this.amount = amount;
        this.price = price;
        this.fuelName = fuelName;
        this.quantity = quantity;
    }

    public String getFuelStationName() {
        return fuelStationName;
    }

    public void setFuelStationName(String fuelStationName) {
        this.fuelStationName = fuelStationName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFuelName() {
        return fuelName;
    }

    public void setFuelName(String fuelName) {
        this.fuelName = fuelName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", fuelStationName='" + fuelStationName + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", fuelName='" + fuelName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
