package com.shop.fuelcoupons.web.order;

import com.shop.fuelcoupons.model.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class OrderController extends AbstractOrderController {

    @GetMapping(value = "order")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping(value = "order")
    public String createOrder(@RequestParam(value = "address") String address) {
        super.create(new Order(address));
        return "redirect:fuels";
    }
}