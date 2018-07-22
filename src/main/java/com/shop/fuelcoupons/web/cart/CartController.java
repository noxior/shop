package com.shop.fuelcoupons.web.cart;

import com.shop.fuelcoupons.model.Cart;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ajax/profile/carts")
public class CartController extends AbstractCartController {

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cart> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/{id}")
    public Cart get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public ResponseEntity<String> createOrUpdate(Cart cart) {
        if (cart.isNew()) {
            super.create(cart);
        } else {
            super.update(cart, cart.getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}