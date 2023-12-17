package com.example.ColaDistributionApp.web;

import com.example.ColaDistributionApp.models.dto.LoggedUser;
import com.example.ColaDistributionApp.models.entity.Order;
import com.example.ColaDistributionApp.models.entity.Plant;
import com.example.ColaDistributionApp.models.entity.Product;
import com.example.ColaDistributionApp.models.entity.Shop;
import com.example.ColaDistributionApp.services.OrderService;
import com.example.ColaDistributionApp.services.PlantService;
import com.example.ColaDistributionApp.services.ProductService;
import com.example.ColaDistributionApp.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {
    private final PlantService plantService;
    private final ShopService shopService;
    private final ProductService productService;
    private final OrderService orderService;

    @Autowired
    public HomeController(PlantService plantService, ShopService shopService, ProductService productService, OrderService orderService) {
        this.plantService = plantService;
        this.shopService = shopService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("home")
    public String home(LoggedUser loggedUser) {
        return "home";
    }

    @ModelAttribute(name = "allPlants")
    public List<Plant> plants() {
        return this.plantService.findAllByUserId();
    }

    @ModelAttribute(name = "allShops")
    public List<Shop> shops() {
        return this.shopService.findAllByUserId();
    }

    @ModelAttribute(name = "allProducts")
    public List<Product> products() {
        return this.productService.findAllByUserId();
    }

    @ModelAttribute(name = "allOrders")
    public List<Order> orders() {
        return this.orderService.findAllByUserId();
    }
}
