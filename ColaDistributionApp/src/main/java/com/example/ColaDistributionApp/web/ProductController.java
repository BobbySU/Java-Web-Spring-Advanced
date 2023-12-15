package com.example.ColaDistributionApp.web;

import com.example.ColaDistributionApp.models.dto.LoggedUser;
import com.example.ColaDistributionApp.models.dto.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("product")
    public String getProduct(LoggedUser loggedUser) {
        return "product-add";
    }

    @ModelAttribute(name = "productDTO")
    public ProductDTO productDTO(){
        return new ProductDTO();
    }
}
