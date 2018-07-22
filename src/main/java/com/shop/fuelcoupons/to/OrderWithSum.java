package com.shop.fuelcoupons.to;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class OrderWithSum extends BaseTo {

    private final LocalDateTime dateTime;

    private final BigDecimal amountOrder;

    private final String status;

    public OrderWithSum(Integer id, LocalDateTime dateTime, BigDecimal amountOrder, String status) {
        super(id);
        this.dateTime = dateTime;
        this.amountOrder = amountOrder;
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public BigDecimal getAmountOrder() {
        return amountOrder;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderWithSum that = (OrderWithSum) o;
        return amountOrder == that.amountOrder &&
                Objects.equals(id, that.id) &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, amountOrder);
    }

    @Override
    public String toString() {
        return "OrderWithSum{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", amountOrder=" + amountOrder +
                ", status='" + status +
                '}';
    }
}