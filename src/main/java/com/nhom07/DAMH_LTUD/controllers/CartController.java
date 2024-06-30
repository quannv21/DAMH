package com.nhom07.DAMH_LTUD.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    @GetMapping("/cart")
    public String showCart() {
        return "cart/cart";
    }

    @GetMapping("/checkout")
    public String showCheckout() {
        return "cart/checkout";
    }

    @GetMapping("/paymentsuccess")
    public String showPaymentsuccess() {
        return "cart/paymentsuccess";
    }


    @GetMapping("/paymentfail")
    public String showPaymentfail() {
        return "cart/paymentfail";
    }

}