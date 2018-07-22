package ru.javawebinar.topjava;

import com.shop.fuelcoupons.model.Cart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static com.shop.fuelcoupons.model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;

public class CartTestData {
    public static final int CART1_ID = START_SEQ + 2;
    public static final int ADMIN_CART_ID = START_SEQ + 8;


    public static final Cart CART1 = new Cart(CART1_ID, "OKKO", new BigDecimal(40.4).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(22.2).setScale(2, RoundingMode.HALF_EVEN), "А92", 2);
    public static final Cart CART2 = new Cart(CART1_ID + 1, "Neftek", new BigDecimal(23.4).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(23.4).setScale(2, RoundingMode.HALF_EVEN), "А95", 1);
    public static final Cart CART3 = new Cart(CART1_ID + 2, "Neftek", new BigDecimal(60).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(20).setScale(2, RoundingMode.HALF_EVEN), "А95+", 3);
    public static final Cart CART4 = new Cart(CART1_ID + 3, "Neftek", new BigDecimal(73.2).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(24.4).setScale(2, RoundingMode.HALF_EVEN), "ГАЗ", 3);
    public static final Cart CART5 = new Cart(CART1_ID + 4, "WOG", new BigDecimal(250).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(25).setScale(2, RoundingMode.HALF_EVEN), "ДТ", 10);
    public static final Cart CART6 = new Cart(CART1_ID + 5, "WOG", new BigDecimal(120).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(12).setScale(2, RoundingMode.HALF_EVEN), "ГАЗ", 10);
    public static final Cart ADMIN_CART1 = new Cart(ADMIN_CART_ID, "Авиас", new BigDecimal(120).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(12).setScale(2, RoundingMode.HALF_EVEN), "ГАЗ", 10);
    public static final Cart ADMIN_CART2 = new Cart(ADMIN_CART_ID + 1, "Авиас", new BigDecimal(120).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(10).setScale(2, RoundingMode.HALF_EVEN), "А92", 12);

    public static final List<Cart> CARTS = Arrays.asList(CART1, CART2, CART3, CART4, CART5, CART6);

    public static Cart getCreated() {
        return new Cart(null, "Neftek", new BigDecimal(150).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(50).setScale(2, RoundingMode.HALF_EVEN), "А95", 3);
    }

    public static Cart getUpdated() {
        return new Cart(CART1_ID, CART1.getFuelStationName(), new BigDecimal(66.6).setScale(2, RoundingMode.HALF_EVEN), new BigDecimal(22.2).setScale(2, RoundingMode.HALF_EVEN), "А92", 3);
    }

    public static void assertMatch(Cart actual, Cart expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "user");
    }

    public static void assertMatch(Iterable<Cart> actual, Cart... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Cart> actual, Iterable<Cart> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("user").isEqualTo(expected);
    }
}
