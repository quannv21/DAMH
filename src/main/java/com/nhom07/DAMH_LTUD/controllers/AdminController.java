package com.nhom07.DAMH_LTUD.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String admin() {
        return "admin/page-index-1";
    }

    @GetMapping("/admin/page-products-list")
    public String product() {
        return "admin/page-products-list";
    }

    @GetMapping("/contact_list")
    public String contact_list() {
        return "admin/contact_list";
    }
}