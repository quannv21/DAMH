package com.nhom07.DAMH_LTUD.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductDetailController {

    @GetMapping("/detail")
    public String showProductDetail() {
        return "productdetail/detail";
    }
}