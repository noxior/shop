package com.shop.fuelcoupons.web.order_detail;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping(value = "/order_details")
public class OrderDetailController extends AbstractOrderDetailController {

    @GetMapping
    public String getAll(HttpServletRequest request, Model model) {
        model.addAttribute("orderDetails", super.getAll(getOrderId(request)));
        return "orderDetails";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }

    private int getOrderId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("orderId"));
        return Integer.valueOf(paramId);
    }
}
