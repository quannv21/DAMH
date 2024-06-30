package com.nhom07.DAMH_LTUD.controllers;

import com.nhom07.DAMH_LTUD.NotFoundByIdException;
import com.nhom07.DAMH_LTUD.model.Country;
import com.nhom07.DAMH_LTUD.model.LeagueClub;
import com.nhom07.DAMH_LTUD.model.Product;
import com.nhom07.DAMH_LTUD.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String showListProduct(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "/products/products-list";
    }

    @GetMapping("products/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "/products/add-product";
    }

    @PostMapping("/products/add")
    public String addProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/products/add-product";
        }
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        try {
            Product product = productService.getById(id);
            model.addAttribute("product", product);
            return "/products/edit-product";
        } catch (NotFoundByIdException e) {
            return "redirect:/products";
        }
    }

    @PostMapping("/products/update/{id}")
    public String updateProduct(@ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "/products/update-product";
        }
        productService.updateProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        try {
            productService.deleteProduct(id);
        } catch (IllegalStateException e) {
            return "redirect:/products";
        }
        return "redirect:/delete-products";
    }
}