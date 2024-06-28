package com.nhom07.DAMH_LTUD.controllers;

import com.nhom07.DAMH_LTUD.NotFoundByIdException;
import com.nhom07.DAMH_LTUD.model.Product;
import com.nhom07.DAMH_LTUD.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/football")
    public String shop() {
        return "layout"; // Tên tệp HTML bạn muốn trả về (không cần đuôi .html)
    }


}