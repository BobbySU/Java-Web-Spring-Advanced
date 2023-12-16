package com.example.ColaDistributionApp.web;

import com.example.ColaDistributionApp.models.dto.LoggedUser;
import com.example.ColaDistributionApp.models.dto.ProductDTO;
import com.example.ColaDistributionApp.services.ProductService;
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
@RequestMapping("/product")
public class ProductController {
    private  final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("product-add")
    public String getProduct(LoggedUser loggedUser) {
        return "product-add";
    }

    @PostMapping("/product-add")
    public String postProduct(@Valid @ModelAttribute(name = "productDTO") ProductDTO productDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute ("productDTO", productDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.productDTO",
                            bindingResult);
            return "redirect:product-add";
        }
        this.productService.addProduct(productDTO);

        return "redirect:/home";
    }

    @ModelAttribute(name = "productDTO")
    public ProductDTO productDTO(){
        return new ProductDTO();
    }
}
