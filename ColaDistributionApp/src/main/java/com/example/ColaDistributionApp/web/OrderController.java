package com.example.ColaDistributionApp.web;

import com.example.ColaDistributionApp.models.dto.LoggedUser;
import com.example.ColaDistributionApp.models.dto.UserDTO;
import com.example.ColaDistributionApp.models.entity.Product;
import com.example.ColaDistributionApp.models.entity.User;
import com.example.ColaDistributionApp.services.ProductService;
import com.example.ColaDistributionApp.services.UserService;
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
    private final LoggedUser loggedUser;
    private final UserService userService;

    @Autowired
    public OrderController(ProductService productService, LoggedUser loggedUser, UserService userService) {
        this.productService = productService;
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @GetMapping("/market")
    public String getPlant() {
        return "market";
    }

    @ModelAttribute(name = "allProducts")
    public List<Product> products() {
        return this.productService.findAllByUserId();
    }

    @ModelAttribute(name = "userProducts")
    public List<Product> userProducts() {
        UserDTO userDTO = this.userService.findById(loggedUser.getId());
        return userDTO.getProducts();
    }
}
