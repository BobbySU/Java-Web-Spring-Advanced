package com.example.ColaDistributionApp.web;

import com.example.ColaDistributionApp.models.dto.LoggedUser;
import com.example.ColaDistributionApp.models.dto.ShopDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @GetMapping("shop")
    public String getShop(LoggedUser loggedUser) {
        return "shop-add";
    }

    @ModelAttribute(name = "shopDTO")
    public ShopDTO shopDTO(){
        return new ShopDTO();
    }
}
