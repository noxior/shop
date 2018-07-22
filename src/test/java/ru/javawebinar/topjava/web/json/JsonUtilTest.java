package ru.javawebinar.topjava.web.json;

import com.shop.fuelcoupons.model.Cart;
import com.shop.fuelcoupons.web.json.JsonUtil;
import org.junit.Test;

import java.util.List;

import static ru.javawebinar.topjava.CartTestData.*;

public class JsonUtilTest {

    @Test
    public void testReadWriteValue() {
        String json = JsonUtil.writeValue(ADMIN_CART1);
        System.out.println(json);
        Cart cart = JsonUtil.readValue(json, Cart.class);
        assertMatch(cart, ADMIN_CART1);
    }

    @Test
    public void testReadWriteValues() {
        String json = JsonUtil.writeValue(CARTS);
        System.out.println(json);
        List<Cart> carts = JsonUtil.readValues(json, Cart.class);
        assertMatch(carts, CARTS);
    }
}