package com.nhom07.DAMH_LTUD.controllers;

import com.nhom07.DAMH_LTUD.NotFoundByIdException;
import com.nhom07.DAMH_LTUD.model.Product;
import com.nhom07.DAMH_LTUD.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductDetailController {

    private final ProductService productService;

    public ProductDetailController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/detail")
    public String showProductDetail() {
        return "productdetail/detail";
    }

    @GetMapping("/detail/{id}")
    public String showProductDetail(@PathVariable("id") Long id, Model model) throws NotFoundByIdException {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "productdetail/detail";
    }
}