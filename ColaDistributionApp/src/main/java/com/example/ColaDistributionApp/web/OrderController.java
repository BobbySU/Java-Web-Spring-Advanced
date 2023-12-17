package com.example.ColaDistributionApp.web;

import com.example.ColaDistributionApp.models.entity.Product;
import com.example.ColaDistributionApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final ProductService productService;

    @Autowired
    public OrderController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/market")
    public String getPlant() {
        return "market";
    }

    @ModelAttribute(name = "allProducts")
    public List<Product> products() {
        return this.productService.findAllByUserId();
    }
}
