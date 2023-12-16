package com.example.ColaDistributionApp.web;

import com.example.ColaDistributionApp.models.dto.LoggedUser;
import com.example.ColaDistributionApp.models.dto.ShopDTO;
import com.example.ColaDistributionApp.services.ShopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/shop")
public class ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("shop-add")
    public String getShop(LoggedUser loggedUser) {
        return "shop-add";
    }

    @PostMapping("/shop-add")
    public String postShop(@Valid @ModelAttribute(name = "shopDTO") ShopDTO shopDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute ("shopDTO", shopDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shopDTO",
                            bindingResult);
            return "redirect:shop-add";
        }
        this.shopService.addShop(shopDTO);

        return "redirect:/home";
    }

    @ModelAttribute(name = "shopDTO")
    public ShopDTO shopDTO() {
        return new ShopDTO();
    }
}
